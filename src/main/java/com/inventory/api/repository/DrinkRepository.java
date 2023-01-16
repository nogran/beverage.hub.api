package com.inventory.api.repository;

import com.inventory.api.domain.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {
    List<Drink> findAll();
}
