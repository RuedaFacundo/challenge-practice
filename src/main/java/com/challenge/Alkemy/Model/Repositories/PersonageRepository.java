package com.challenge.Alkemy.Model.Repositories;

import com.challenge.Alkemy.Model.Entities.Personage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "personageRepository")
public interface PersonageRepository extends JpaRepository<Personage, Integer> {
}
