package petpj.ecommerce.ashion.pkgs.exception;

import org.springframework.http.HttpStatus;

public class InternalServerException extends HttpException {

  public InternalServerException(String msg) {
    super(HttpStatus.INTERNAL_SERVER_ERROR, msg);
  }
}
