package com.inventory.api.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "USER_SEQ", allocationSize = 1)
    private Long id;

    @NotBlank(message = "Atributo 'nome' precisa ser inserido.")
    @Size(min = 5, max = 255, message = "Atributo 'nome' precisa ter '5' números mínimos de caracteres e '255' números máximos de caracteres.")
    @Column(name = "name")
    private String name;

    @Email
    @NotBlank(message = "Atributo 'email' precisa ser inserido.")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Atributo 'senha' precisa ser inserido.")
    @Size(min = 8, message = "Atributo 'senha' precia ter '8' números mínimos de caracteres.")
    @Column(name = "password")
    private String password;
}
