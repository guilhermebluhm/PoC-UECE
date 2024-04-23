package com.example.demo.utils.misc;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReadFileXLSX {

    int it = 0;
    String cellValue = "";
    private List<String> agrupamentos;
    private List<Integer> limitesAgrupamentos = new ArrayList<>();
    private HashMap<Integer, List<String>> controle = new HashMap<>();

    public void getData() {

        String pathToFile = "C:\\Users\\guilherme.bluhm\\Documents\\GitHub\\PoC-UECE\\src\\main\\resources\\arquivosXLSX\\mapaItapipoca.xlsx";

        try (FileInputStream file = new FileInputStream((pathToFile));
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheetAt(0); // Acessa a primeira aba da planilha
            int maxNumOfColumns = getMaxColumns(sheet);

            //para identificar os agrupamentos baseado em COORD
            for (Row row : sheet) {

                /*
                    condicao de parada da coluna
                    indice 0 -> visitar para saber os limites para cada agrupamento
                */

                Cell cell = row.getCell(0);
                if (cell == null || cell.getCellType() == CellType.BLANK) {
                    break;
                }
                if (it != 0) {

                    cellValue = getCellValue(cell);
                    double v = Double.parseDouble(cellValue);
                    int i = (int) v;

                    if (!controle.containsKey(i))
                        agrupamentos = new ArrayList<>();

                    agrupamentos.add(cellValue);
                    controle.put(i, agrupamentos);
                }
                it += 1;

            }

            for (List<String> v : controle.values()) {
                limitesAgrupamentos.add(v.size());
            }

            /*
                aqui já consigo saber quantos objetos devo criar
                baseado no arquivo XLSX
            */

            String nomeEscola = "";
            String endereco = "";
            String bairro = "";

            /*
                col = 0 sera a coluna de agrupamento que e COORD
                se necessario incluir, colocar col = 0 no laço
             */

            for (int col = 1; col < maxNumOfColumns - 1; col += 1) {

                /*

                    1 -> coluna escola
                    2 -> coluna endereco
                    3 -> coluna bairro
                    4 -> coluna 'sala escola', deve iterar de acordo com os limites do limitesAgrupamentos
                    5 -> coluna 'sala cev', deve deve iterar de acordo com os limites do limitesAgrupamentos
                    6 -> coluna 'candidato', deve iterar de acordo com os limites do limitesAgrupamentos

                 */

                //requer montar logica personalizada

                it = 0;
                boolean primeiroElemento = true;
                int qdoParar = 0;
                int controleRepeticoes = 0;
                for (Row row : sheet) {

                    if(        col == 1
                            || col == 2
                            || col == 3
                            || col == 4
                            || col == 5
                            || col == 6
                    ) {

                        if(it == 1){

                            //primeiro elemento antes do salto
                            if(qdoParar == 0 && primeiroElemento){
                                String cellV = getCellValue(row.getCell(col));
                                System.out.println(cellV);
                                primeiroElemento = false;
                            }

                            //logica de saltos para repeticoes
                            if(qdoParar == limitesAgrupamentos.get(controleRepeticoes)){
                                String cellV = getCellValue(row.getCell(col));
                                System.out.println(cellV);
                                controleRepeticoes+=1;
                                qdoParar = 0;
                            }

                            if(controleRepeticoes == limitesAgrupamentos.size())
                                break;

                            qdoParar+=1;
                        }

                        if(it == 2){

                            /*
                                motivação da logica:

                                vai realizar as N iteracoes para cada grupo de SALA escola, SALA cev e CANDIDATO
                                partindo da montagem com salto das escolas que foram identificadas no XLSX

                             */

                            if(qdoParar < limitesAgrupamentos.get(controleRepeticoes)){
                                String cellV = getCellValue(row.getCell(col));
                                qdoParar+=1;
                                System.out.println(cellV);

                            }

                            if(qdoParar == limitesAgrupamentos.get(controleRepeticoes)) {
                                controleRepeticoes += 1;
                                qdoParar = 0;
                            }

                            if(controleRepeticoes == limitesAgrupamentos.size())
                                break;

                        }

                    }
                    if(col == 1 || col == 2 || col == 3)
                        it = 1;
                    else if(col == 4 || col == 5 || col == 6)
                        it = 2;

                }
                primeiroElemento = true;
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getMaxColumns(Sheet sheet) {
        int maxNumOfColumns = 0;
        for (Row row : sheet) {
            maxNumOfColumns = Math.max(maxNumOfColumns, row.getLastCellNum()); // Índice baseado em 0
        }
        return maxNumOfColumns;
    }

    private static String getCellValue(Cell cell) {
        if (cell == null) {
            return " ";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return Double.toString(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return Boolean.toString(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return " ";
        }
    }
}