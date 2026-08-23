package com.codexa.lacvita.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codexa.lacvita.model.DocumentoSaude;

@Repository
public interface DocumentoSaudeRepository extends JpaRepository<DocumentoSaude, Long> {
    List<DocumentoSaude> findByNutrizeId(Long nutrizeId);
}