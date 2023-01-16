package com.inventory.domain.model;

import lombok.Data;

@Data
public class UserLogin {

    private Long id;

    private String name;

    private String user;

    private String password;

    private String token;

}
