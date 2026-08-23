package com.codexa.lacvita.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codexa.lacvita.model.QualidadeLeite;

@Repository
public interface QualidadeLeiteRepository extends JpaRepository<QualidadeLeite, Long> {
    Optional<QualidadeLeite> findByColetaId(Long coletaId);
}