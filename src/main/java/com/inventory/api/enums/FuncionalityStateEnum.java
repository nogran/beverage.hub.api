package com.inventory.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FuncionalityStateEnum {
    ON("ACTIVATE", "ATIVO"),
    OFF("DEACTIVATE", "DESATIVADO"),
    EXPIRED("EXPIRED", "VENCIDO");

    private final String name;
    private final String namePtBr;
}
