package com.inventory.controller;

import java.util.List;

import com.inventory.service.DrinkService;
import com.inventory.domain.model.Drink;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inventory")
@Slf4j
@AllArgsConstructor
public class DrinkController {

    private final DrinkService drinkService;

    @GetMapping(value = "/drinks")
    public ResponseEntity<List<Drink>> getAll() {
        return ResponseEntity.ok(drinkService.findAll());
    }

    @PostMapping(value = "/drinks")
    public ResponseEntity<Drink> saveDrink(Drink drink) {
        return ResponseEntity.ok(drinkService.save(drink));
    }
}