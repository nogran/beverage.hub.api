package com.inventory.domain.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name = "drink")
public class Drink {

    @Id
    private Long id;

    //    @NotNull
//    @NotBlank(message = "Atributo nome precisa ser inserido.")
//    @Size(min = 5, max = 255, message = "Número mínimo de caracteres é 5 e número máximo de caracteres é 255.")
    @Column(name = "name")
    private String name;

    //    @NotNull(message = "Atributo quantidade precisa ser inserido.")
    @Column(name = "quantity")
    private int quantity;

    //    @NotNull(message = "Preço é obrigatório.")
//    @Positive(message = "O preço deve ser maior do que zero.")
    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "expiration_date")
    private Date expirationDate;

    //    @NotNull(message = "Volume é obrigatório.")
//    @Positive(message = "O Volume deve ser maior do que zero.")
    @Column(name = "volume")
    private BigDecimal volume;

    //    @NotNull
    @Column(name = "activate")
    private Boolean activate;

    @ManyToOne
    private User user;

    @ManyToOne
    private Section section;
}