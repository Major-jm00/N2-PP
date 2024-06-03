package br.n2.picpay.desafio_pp_n2.transaction;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TransactionExceptionHandler {
      @ExceptionHandler(invalidTransactionException.class)
  public ResponseEntity<Object> handle(invalidTransactionException e) {
    return ResponseEntity.badRequest().body(e.getMessage());
  }
}

