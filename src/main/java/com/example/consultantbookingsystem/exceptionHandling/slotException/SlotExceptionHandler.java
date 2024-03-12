package com.example.consultantbookingsystem.exceptionHandling.slotException;

import com.example.consultantbookingsystem.exceptionHandling.userException.UserErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class SlotExceptionHandler {

    //For validators
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<SlotErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errorMessages = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());

        SlotErrorResponse errorResponse = buildErrorResponse(HttpStatus.BAD_REQUEST, "Bad Request", errorMessages);
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<SlotErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex){
            List<String> errorMessages = Collections.singletonList("Data integrity violation occurred");
            SlotErrorResponse errorResponse = buildErrorResponse(HttpStatus.BAD_REQUEST, "Bad Request", errorMessages);
            return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(SlotOverlapException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<SlotErrorResponse> handleSlotOverlapException(SlotOverlapException ex) {
        List<String> errorMessages = Collections.singletonList(ex.getMessage());
        SlotErrorResponse errorResponse = buildErrorResponse(HttpStatus.CONFLICT, "Conflict", errorMessages);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    private SlotErrorResponse buildErrorResponse(HttpStatus status, String error, List<String> messages) {
        return new SlotErrorResponse(
                status.value(),
                error,
                messages,
                LocalDateTime.now()
        );
    }


}
