package solipsismal.olympiacosfcapp.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import solipsismal.olympiacosfcapp.dto.ErrorResponseDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final String INTERNAL_CODE_ERROR = "InternalServerError";
    private static final String INTERNAL_CODE_MESSAGE = "An unexpected error occurred.";

    @ExceptionHandler(AppGenericException.class)
    public ResponseEntity<ErrorResponseDTO> handleAppGenericException(AppGenericException e) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(e.getCode(), e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGenericException(Exception e) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(INTERNAL_CODE_ERROR, INTERNAL_CODE_MESSAGE);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDTO);
    }
}