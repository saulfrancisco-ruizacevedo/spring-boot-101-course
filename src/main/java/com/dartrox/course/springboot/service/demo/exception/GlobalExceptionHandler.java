package com.dartrox.course.springboot.service.demo.exception;

import com.dartrox.course.springboot.service.demo.dto.response.CustomErrorResponseDTO;
import com.dartrox.course.springboot.service.demo.exception.customExceptions.BadRequestException;
import com.dartrox.course.springboot.service.demo.exception.customExceptions.CustomAbstractException;
import com.dartrox.course.springboot.service.demo.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomAbstractException.class)
    public ResponseEntity<CustomErrorResponseDTO> handleCustomAbstractException(HttpServletRequest request, BadRequestException ex) {

        final CustomErrorResponseDTO customErrorResponseDTO = CustomErrorResponseDTO.builder()
                .statusCode(ex.getStatus())
                .errorMessage(ex.getCustomErrorMessage())
                .field(ex.getField())
                .value(ex.getValue())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(ex.getStatus()).body(customErrorResponseDTO);
    }


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<CustomErrorResponseDTO> handleNullPointerException(HttpServletRequest request, NullPointerException ex) {

        final CustomErrorResponseDTO customErrorResponseDTO = CustomErrorResponseDTO.builder()
                .statusCode(BAD_REQUEST)
                .errorMessage(ex.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(customErrorResponseDTO.getStatusCode()).body(customErrorResponseDTO);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorResponseDTO> handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException ex) {
        final BindingResult bindingResult = ex.getBindingResult();

        final CustomErrorResponseDTO customErrorResponseDTO = CustomErrorResponseDTO.builder()
                .statusCode(BAD_REQUEST)
                .path(request.getRequestURI())
                .build();

        bindingResult.getFieldErrors()
                .forEach(fieldError -> {
                    customErrorResponseDTO.setErrorMessage(StringUtils.concatenateWithComma(customErrorResponseDTO.getErrorMessage(), fieldError.getDefaultMessage()));
                    customErrorResponseDTO.setField(StringUtils.concatenateWithComma(customErrorResponseDTO.getField(), fieldError.getField()));
                    customErrorResponseDTO.setValue(StringUtils.concatenateWithComma(customErrorResponseDTO.getValue(), getJakartaValue(fieldError)));
                });

        return ResponseEntity.status(customErrorResponseDTO.getStatusCode()).body(customErrorResponseDTO);
    }

    protected String getJakartaValue(FieldError fieldError) {
        return  (fieldError.getRejectedValue() == null) ? "null" :
                (fieldError.getRejectedValue().toString().isEmpty() ? "blank" : fieldError.getRejectedValue().toString());
    }
}
