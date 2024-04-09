package com.example.demo.repository;

import com.example.demo.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
ainda montar a logica do candidato que estara para a escola
 */

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}
