package petpj.ecommerce.ashion.pkgs.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends HttpException {

  public BadRequestException(String msg) {
    super(HttpStatus.BAD_REQUEST, msg);
  }
}
