package com.codexa.lacvita.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codexa.lacvita.model.Coleta;

@Repository
public interface ColetaRepository extends JpaRepository<Coleta, Long> {
    Optional<Coleta> findByAgendamentoId(Long agendamentoId);
}