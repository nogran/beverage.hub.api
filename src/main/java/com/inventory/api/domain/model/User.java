package com.inventory.domain.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    private Long id;

    @NotBlank(message = "Atributo Nome precisa ser inserido.")
    @Size(min = 5, max = 255, message = "Número mínimo de caracteres é 5 e número máximo de caracteres é 255.")
    private String name;

    @Schema(example = "email@email.com")
    @Email
    @NotBlank(message = "Atributo Email precisa ser inserido.")
    private String user;

    @NotBlank(message = "Atributo senha precisa ser inserido.")
    @Size(min = 8, message = "Número mínimo é 8 caracteres.")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Drink> drinks;

}
