package dev.alfrendosilalahi.project.exeption.handler;

import dev.alfrendosilalahi.project.dto.response.BaseErrorResponseDto;
import dev.alfrendosilalahi.project.exeption.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<BaseErrorResponseDto>  handleEntityNotFoundException(EntityNotFoundException e) {
        var response = BaseErrorResponseDto.builder()
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
