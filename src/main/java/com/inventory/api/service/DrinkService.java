package com.inventory.service;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.inventory.domain.model.Drink;
import com.inventory.repository.DrinkRepository;

import javax.transaction.Transactional;

@Slf4j
@Service
@AllArgsConstructor
@Transactional
public class DrinkService {

    private final DrinkRepository drinkRepository;
    public List<Drink> findAll() {
        return drinkRepository.findAll();
    }

    public Drink save(Drink drink) {
        return drinkRepository.save(drink);
    }
}
