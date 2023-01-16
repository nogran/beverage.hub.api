package com.inventory.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SectionEnum {
    ALCOHOLIC("ALCOHOLIC","ALCOÓLICAS"),
    NON_ALCOHOLIC("NON ALCOHOLIC","NÃO ALCOÓLICAS");

    private final String name;
    private final String namePtBr;
}
