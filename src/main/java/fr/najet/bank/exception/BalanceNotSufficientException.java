package fr.najet.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BalanceNotSufficientException extends Exception {


  private static final long serialVersionUID = 1L;

  public BalanceNotSufficientException(String message) {
    super(message);
  }

}
