package com.codexa.lacvita.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponse(
        int status,
        String erro,
        List<String> detalhes,
        LocalDateTime timestamp) {
}
