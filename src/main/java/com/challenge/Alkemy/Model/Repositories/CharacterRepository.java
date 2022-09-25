package com.challenge.Alkemy.Model.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "characterRepository")
public interface CharacterRepository extends JpaRepository<Character, Integer> {
}
