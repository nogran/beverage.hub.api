package com.inventory.api.service;

import com.inventory.api.domain.model.Section;
import com.inventory.api.repository.SectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SectionService {
    private final SectionRepository sectionRepository;

    public List<Section> findAll(){
        return sectionRepository.findAll();
    }

    public Section save(Section section){
        return sectionRepository.save(section);
    }
}
