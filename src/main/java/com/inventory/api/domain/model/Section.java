package com.inventory.api.domain.model;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "sections")
public class Section {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(generator = "section_seq")
    @SequenceGenerator(name = "section_seq", sequenceName = "SECTION_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    @NotNull(message = "Atributo 'nome' precisa ser inserido.")
    @Size(min = 5, max = 255, message = "Atributo 'nome' precisa ter entre '5' e '255' caracteres.")
    private String name;

    @Column(name = "category")
    @NotNull(message = "Atributo 'categoria' precisa ser inserido.")
    private String category;

    @Column(name = "volume")
    @NotNull(message = "Atributo 'volume' precisa ser inserido.")
    @Positive(message = "Atributo 'volume' precisa ser maior do que zero.")
    private BigDecimal volume;

    @Column(name = "created_by")
    @NotNull(message = "Atributo 'criado por' precisa ser inserido.")
    private String createdBy;

    @OneToMany(mappedBy = "section")
    private List<Drink> drinks;
}