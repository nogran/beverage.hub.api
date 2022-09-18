package com.inventory.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name = "drink")
public class Drink {

    @Id
    private Long id;

    @NotNull
    @NotBlank(message = "Atributo nome precisa ser inserido.")
    @Size(min = 5, max = 255, message = "Número mínimo de caracteres é 5 e número máximo de caracteres é 255.")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Atributo quantidade precisa ser inserido.")
    @Column(name = "quantity")
    private int quantity;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull(message = "Preço é obrigatório.")
    @Positive(message = "O preço deve ser maior do que zero.")
    @Column(name = "price")
    private BigDecimal price;

    //    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @NotNull(message = "Volume é obrigatório.")
    @Positive(message = "O Volume deve ser maior do que zero.")
    @Column(name = "volume")
    private BigDecimal volume;

    @NotNull
    @Column(name = "type")
    private String type;

    @NotNull
    @Column(name = "section")
    private String section;

    @ManyToMany(mappedBy = "drinks")
    private List<User> users;

}