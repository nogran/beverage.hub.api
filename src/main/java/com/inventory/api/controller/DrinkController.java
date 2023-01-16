package com.inventory.api.controller;

import java.util.List;

import com.inventory.api.domain.dto.ResponseDTO;
import com.inventory.api.service.DrinkService;
import com.inventory.api.domain.model.Drink;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequestMapping("/api/v1/inventory")
@Slf4j
@AllArgsConstructor
public class DrinkController {
    private final DrinkService drinkService;

    @GetMapping(value = "/drinks")
    public ResponseEntity<ResponseDTO<List<Drink>>> getAll() {
        return ResponseEntity.ok(new ResponseDTO<>(drinkService.findAll()));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ResponseDTO<Drink>> saveDrink(Drink drink) {
        return ResponseEntity.ok(new ResponseDTO<>(drinkService.save(drink)));
    }
}