package com.inventory.controller;

import java.util.List;

import com.inventory.service.SectionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inventory.domain.model.Section;

import javax.validation.Valid;

@Controller
@RequestMapping("/section")
@AllArgsConstructor
public class SectionController {
    private final SectionService sectionService;

    @GetMapping
    public ResponseEntity<List<Section>> getAll() {
        return ResponseEntity.ok(sectionService.findAll());
    }

    @PostMapping(value="/section")
    public ResponseEntity<Section> postSection(@Valid @RequestBody Section section){
        return ResponseEntity.ok(sectionService.saveSection(section));
    }
}
