package dev.manuel.authority;

import dev.manuel.clients.exception.SecureAppException;
import dev.manuel.clients.lasting.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CredentialExceptionHandling extends ResponseEntityExceptionHandler {

  @ExceptionHandler(SecureAppException.class)
  public ResponseEntity<Object> handleSecureException(SecureAppException exception, WebRequest webRequest) {
    ExceptionResponse response = ExceptionResponse.builder()
      .code(exception.getCode())
      .message(exception.getMessage())
      .build();
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
