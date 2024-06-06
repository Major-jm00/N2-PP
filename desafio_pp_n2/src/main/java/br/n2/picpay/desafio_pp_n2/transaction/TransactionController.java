package br.n2.picpay.desafio_pp_n2.transaction;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * A classe TransactionController é um controlador REST que manipula operações de transação.
 * Ela contém métodos para listar todas as transações e criar uma nova transação.
 *
 * @param transactionService O serviço de transação usado para realizar operações de transação.
 */

@RestController
@RequestMapping("transaction")
public class TransactionController {
    private final TransactionService transactionService;

  public TransactionController(TransactionService transactionService) {
    this.transactionService = transactionService;
  }


   /**
     * Lista todas as transações.
     *
     * @return Uma lista de todas as transações.
     */
  @GetMapping
  public List<Transaction> list() {
    return transactionService.list();
  }

  /**
     * Cria uma nova transação.
     *
     * @param transaction A transação a ser criada.
     * @return A transação criada.
     */

  @PostMapping
  public Transaction createTransaction(@RequestBody Transaction transaction) {
    return transactionService.create(transaction);
  }

}

