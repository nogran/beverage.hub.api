package com.inventory.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "section")
@Data
public class Section {

    @Id
    private Long id;

    //	@NotBlank(message = "Atributo nome precisa ser inserido.")
    @Size(min = 5, max = 255, message = "Número mínimo de caracteres é 5 e número máximo de caracteres é 255.")
    private String name;

    //	@NotBlank(message = "Atributo Tipo precisa ser inserido.")
    @Size(min = 5, max = 255, message = "Número mínimo de caracteres é 5 e número máximo de caracteres é 255.")
    private String section;

    //    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull(message = "Volume é obrigatório.")
    @Positive(message = "O Volume deve ser maior do que zero.")
    private BigDecimal volume;

    //    @JsonIgnoreProperties("secao")
    @OneToMany(mappedBy = "section", cascade = CascadeType.REMOVE)
    private List<Drink> drink;

}