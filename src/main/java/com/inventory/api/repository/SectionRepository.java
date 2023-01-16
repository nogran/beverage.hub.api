package com.inventory.api.repository;

import java.util.List;

import com.inventory.api.domain.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
    List<Section> findAll();
}
