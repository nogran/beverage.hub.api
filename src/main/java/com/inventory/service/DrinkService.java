package com.inventory.service;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.inventory.model.Drink;
import com.inventory.repository.DrinkRepository;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class DrinkService {

    private final DrinkRepository drinkRepository;

    public List<Drink> findAll() {
        return drinkRepository.findAll();
    }
}
