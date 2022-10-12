package petpj.ecommerce.ashion.pkgs.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends HttpException {

  public NotFoundException(String msg) {
    super(HttpStatus.NOT_FOUND, msg);
  }
}
