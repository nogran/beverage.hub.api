package com.inventory.api.domain.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResponseDTO<T> {
    private T response;
    private List<ErrorDTO> errors;

    public ResponseDTO(T response) {
        this.response = response;
    }

    public ResponseDTO(ErrorDTO errorDTO) {
        if (errors == null) {
            errors = new ArrayList<>();
        }
        errors.add(errorDTO);
    }

    public ResponseDTO(List<ErrorDTO> errorDTOs) {
        if (errors == null) {
            errors = new ArrayList<>();
        }
        errors.addAll(errorDTOs);
    }
}
