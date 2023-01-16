package com.inventory.api.service;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.inventory.api.domain.model.Drink;
import com.inventory.api.repository.DrinkRepository;

@Service
@Slf4j
@AllArgsConstructor
public class DrinkService {
    private final DrinkRepository drinkRepository;

    public List<Drink> findAll() {
        return drinkRepository.findAll();
    }

    public Drink save(Drink drink) {
        return drinkRepository.save(drink);
    }
}
