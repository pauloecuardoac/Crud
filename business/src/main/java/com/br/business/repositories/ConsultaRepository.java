package com.br.business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.business.entities.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
