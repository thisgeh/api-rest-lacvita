package com.codexa.lacvita.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codexa.lacvita.model.Nutrize;

@Repository
public interface NutrizeRepository extends JpaRepository<Nutrize, Long> {
    Optional<Nutrize> findByEmail(String email);
    Optional<Nutrize> findByCpf(String cpf);
}