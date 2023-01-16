package com.inventory.api.domain.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "drinks")
@AllArgsConstructor
public class Drink {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(generator = "drink_seq")
    @SequenceGenerator(name = "drink_seq", sequenceName = "DRINK_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    @NotNull(message = "Atributo 'nome' precisa ser inserido.")
    @Size(min = 5, max = 255, message = "Atributo 'nome' precisa ter entre '5' e '255' caracteres.")
    private String name;

    @Column(name = "quantity")
    @NotNull(message = "Atributo 'quantidade' precisa ser inserido.")
    private int quantity;

    @Column(name = "price")
    @NotNull(message = "Atributo 'preço' precisa ser inserido.")
    @Positive(message = "Atributo 'preço' precisa ser maior do que zero.")
    private BigDecimal price;

    @Column(name = "expiration_date")
    @NotNull(message = "Atributo 'data de validade' precisa ser inserido.")
    private Date expirationDate;

    @Column(name = "volume")
    @NotNull(message = "Atributo 'volume' precisa ser inserido.")
    @Positive(message = "Atributo 'volume' precisa ser maior do que zero.")
    private BigDecimal volume;

    @Column(name = "type")
    @NotNull(message = "Atributo 'tipo' precisa ser inserido.")
    private String type;

    @Column(name = "functionality_state")
    @NotNull(message = "Atributo 'estado de funcionalidade' precisa ser inserido.")
    private String functionalityState;

    @ManyToOne
    @JoinColumn(name = "section_id")
    @NotNull(message = "Atributo 'seção' precisa ser inserido.")
    private Section section;
}