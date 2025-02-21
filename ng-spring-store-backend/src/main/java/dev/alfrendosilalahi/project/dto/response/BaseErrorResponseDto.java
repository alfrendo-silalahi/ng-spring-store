package dev.alfrendosilalahi.project.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseErrorResponseDto {

    private String message;

    private LocalDateTime timestamp;

}
