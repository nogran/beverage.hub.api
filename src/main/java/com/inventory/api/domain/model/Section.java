package com.inventory.domain.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Positive;

import lombok.Data;

@Entity
@Data
@Table(name = "section")
public class Section {

    @Id
    private Long id;

    //	@NotBlank(message = "Atributo nome precisa ser inserido.")
//    @Size(min = 5, max = 255, message = "Número mínimo de caracteres é 5 e número máximo de caracteres é 255.")
    @Column(name = "name")
    private String name;

    //	@NotBlank(message = "Atributo Tipo precisa ser inserido.")
//    @Size(min = 5, max = 255, message = "Número mínimo de caracteres é 5 e número máximo de caracteres é 255.")
    @Column(name = "category")
    private String category;

//    @NotNull(message = "Volume é obrigatório.")
    @Positive(message = "O Volume deve ser maior do que zero.")
    @Column(name = "volume")
    private BigDecimal volume;

    @Column(name = "created_by")
    private String createdBy;

    @OneToMany(mappedBy = "section")
    private List<Drink> drinks;


}