package com.inventory.repository;

import java.util.List;

import com.inventory.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {
    List<Drink> findAll();
}
