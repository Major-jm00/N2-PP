package br.n2.picpay.desafio_pp_n2.transaction;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * A classe TransactionHandler é um conselho de controlador que manipula exceções de transações inválidas.
 */

@ControllerAdvice
public class TransactionHandler {

  /**
     * Manipula exceções de transações inválidas.
     *
     * @param e A exceção de transação inválida.
     * @return Uma resposta de erro HTTP com a mensagem da exceção.
     */
      @ExceptionHandler(invalidTransactionException.class)
  public ResponseEntity<Object> handle(invalidTransactionException e) {
    return ResponseEntity.badRequest().body(e.getMessage());
  }
}
    
