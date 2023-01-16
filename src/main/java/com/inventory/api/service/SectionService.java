package com.inventory.service;

import com.inventory.domain.model.Section;
import com.inventory.repository.SectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class SectionService {
    private final SectionRepository sectionRepository;

    public List<Section> findAll(){
        return sectionRepository.findAll();
    }

    public Section saveSection(Section section){
        return sectionRepository.save(section);
    }
}
