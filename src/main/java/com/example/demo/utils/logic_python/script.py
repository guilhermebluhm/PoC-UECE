# -*- coding: utf-8 -*-

import pandas as pd
import csv

print("script iniciado")
pd.set_option('display.max_rows', None)
df = pd.read_excel('C:\\Users\\guilherme.bluhm\\Documents\\GitHub\\PoC-UECE\\src\\main\\java\\com\\example\\demo\\utils\\logic_python\\mapa.xlsx', engine='openpyxl')
df = df.sort_values(by=['Sala CEV'], ascending=[True])

df2 = pd.read_excel('C:\\Users\\guilherme.bluhm\\Documents\\GitHub\\PoC-UECE\\src\\main\\java\\com\\example\\demo\\utils\\logic_python\\candidatos.xlsx')
if "Inscrição" in df2.columns:
    df2 = df2[df2['Inscrição'] != 'Indeferido']
if "Segmento" in df2.columns:
    df2 = df2[~df2['Segmento'].str.contains('PcD')]
df2['Cargo'] = df2['Cargo'].str.strip().str.lower()

class Room:
    def __init__(self, name: str, capacity: int, school_name: str):
        self.name = name
        self.capacity = capacity
        self.occupied_space = 0
        self.sectors_in_room = []
        self.school_name = school_name

    def add_sector(self, sector):
        if self.occupied_space + sector.quantity <= self.capacity:
            self.sectors_in_room.append(sector)
            self.occupied_space += sector.quantity
            return True
        return False

    def add_candidate_to_sector(self, candidate):
        for sector in self.sectors_in_room:
            if sector.name == candidate.sector:
                sector.candidates.append(candidate)
                return True
        return False

    def __str__(self):
        sectors_str = ', '.join([f"{sector['name']} ({sector['occupied']})" for sector in self.sectors_in_room])
        return f"{self.name}: Total Occupied {self.occupied_space}/{self.capacity}, Sectors: {sectors_str}"

class Sector:
    def __init__(self, code: int, name: str, quantity: int):
        self.code = code
        self.name = name
        self.quantity = quantity
        self.candidates = []

    def __str__(self):
        return f"{self.code} {self.name} {self.quantity}"

class Candidate:
    def __init__(self, request: int, name: str, sector_code: int, segment):
        self.request = request
        self.name = name
        self.sector_code = sector_code
        self.segment = segment

    def __str__(self):
        return self.name

rooms = []
for index, row in df.iterrows():
    room_name = f"{row['Sala CEV']}"
    capacity = row['CANDIDATO']
    school_name = f"{row['ESCOLA']}"
    room = Room(name=room_name, capacity=capacity, school_name=school_name)
    rooms.append(room)

sectors = []
total = 0
for code, (name, quantity) in enumerate(df2.groupby('Cargo').size().items(), start=1):
    sector = Sector(code=code, name=name, quantity=quantity)
    sectors.append(sector)
    total += quantity
sectors = sorted(sectors, key=lambda sector: sector.quantity, reverse=False)
for sector in sectors:
    print(sector)
print(f"Total: {total}")

total = 0
for index, row in df2.iterrows():
    request = int(row['Pedido'])
    name = row['Nome']
    sector_name = row['Cargo']
    sector_code = row['Cód']
    segment = row['Segmento']
    candidate = Candidate(request=request, name=name, sector_code=sector_code, segment=segment)
    for sector in sectors:
        if sector.name == sector_name:
            sector.candidates.append(candidate)
            total += 1
            break
print(f"Total: {total}")
for sector in sectors:
    print(sector)
    for candidate in sector.candidates:
        print(f"\t{candidate}")

new_sectors = sectors[:]
new_rooms = rooms[:]

def distribute_sectors(rooms, sectors):
    sectors.sort(key=lambda x: x.quantity, reverse=False)

    for sector in sectors:
        rooms.sort(key=lambda x: x.occupied_space, reverse=False)
        for room in rooms:
            if room.occupied_space == 0 or room.capacity - room.occupied_space >= sector.quantity:
                while sector.quantity > 0 and room.capacity - room.occupied_space > 0:
                    amount_to_place = min(sector.quantity, room.capacity - room.occupied_space)
                    sector_split = Sector(sector.code, sector.name, amount_to_place)
                    sector_split.candidates = sector.candidates[:amount_to_place]
                    room.add_sector(sector_split)
                    sector.quantity -= amount_to_place
                    sector.candidates = sector.candidates[amount_to_place:]
                    if sector.quantity == 0:
                        break
                if sector.quantity == 0:
                    break

    for sector in [sector for sector in sectors if sector.quantity]:
        rooms.sort(key=lambda x: x.capacity - x.occupied_space)
        for room in rooms:
            if(room.capacity - room.occupied_space == 0):
                continue
            if room.add_sector(sector):
                break

distribute_sectors(new_rooms, new_sectors)

for room in rooms:
    if(room.occupied_space):
        print(f"{room.name} - ({room.occupied_space}/{room.capacity}) - {room.school_name}")
        for sector in room.sectors_in_room:
            print(f"\tCódigo: {sector.code} Cargo: {sector.name} - Quantidade: {sector.quantity}")

def sorting_key(obj):
    digit_part = int(obj.name)
    return (digit_part)

final_rooms = sorted(new_rooms, key=sorting_key)

for room in final_rooms:
    if(room.occupied_space == 0):
        continue
    print(f"Sala CEV {room.name} - ({room.occupied_space}/{room.capacity})  - {room.school_name}")
    for sector in room.sectors_in_room:
        print(f"  - {sector.name} ({sector.quantity}): ", ", ".join([str(c.request) for c in sector.candidates]))

with open('candidate_allocations.csv', 'w', newline='') as file:
    writer = csv.writer(file, delimiter=';', quotechar='"', quoting=csv.QUOTE_MINIMAL)
    writer.writerow(["PEDIDO", "CANDIDATO", "CODIGO", "CARGO", "SEGMENTO"])
    for room in final_rooms:
        if room.occupied_space == 0:
            continue

        writer.writerow([f"Sala CEV {room.name} - ({room.occupied_space}/{room.capacity}) - {room.school_name}"])


        for sector in room.sectors_in_room:
            for candidate in sector.candidates:
                writer.writerow([candidate.request, candidate.name, candidate.sector_code, sector.name, candidate.segment])