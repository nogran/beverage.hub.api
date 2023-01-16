package com.inventory.api.filter;

import com.inventory.api.domain.dto.ResponseDTO;
import com.inventory.api.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleUserNotFoundException(
            UserNotFoundException e, WebRequest request) {
        return ResponseEntity.badRequest()
                .body(new ResponseDTO<>(HttpStatus.BAD_REQUEST.toString()));
    }
}
