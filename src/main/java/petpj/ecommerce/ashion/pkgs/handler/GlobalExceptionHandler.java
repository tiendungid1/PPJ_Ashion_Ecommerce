package petpj.ecommerce.ashion.pkgs.handler;

import petpj.ecommerce.ashion.pkgs.exception.HttpException;
import petpj.ecommerce.ashion.pkgs.exception.InternalServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
@ResponseStatus
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<HttpException> handleUnwantedException(Exception e) {
    log.error("Error reading configuration file", e);
    return new InternalServerException("Unknown error").toResponse();
  }
}
