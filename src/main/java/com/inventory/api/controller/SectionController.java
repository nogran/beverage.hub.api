package com.inventory.api.controller;

import java.util.List;

import com.inventory.api.domain.model.Section;
import com.inventory.api.service.SectionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/v1/inventory")
@AllArgsConstructor
public class SectionController {
    private final SectionService sectionService;

    @GetMapping(value = "/section")
    public ResponseEntity<List<Section>> getAll() {
        return ResponseEntity.ok(sectionService.findAll());
    }

    @PostMapping(value="/section")
    public ResponseEntity<Section> postSection(@Valid @RequestBody Section section){
        return ResponseEntity.ok(sectionService.save(section));
    }
}
