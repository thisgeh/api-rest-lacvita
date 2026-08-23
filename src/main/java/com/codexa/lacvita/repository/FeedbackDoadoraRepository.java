package com.codexa.lacvita.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codexa.lacvita.model.FeedbackDoadora;

@Repository
public interface FeedbackDoadoraRepository extends JpaRepository<FeedbackDoadora, Long> {
    List<FeedbackDoadora> findByNutrizeId(Long nutrizeId);
}