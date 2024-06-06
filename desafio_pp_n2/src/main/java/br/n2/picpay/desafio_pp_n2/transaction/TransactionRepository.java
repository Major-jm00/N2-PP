package br.n2.picpay.desafio_pp_n2.transaction;

import org.springframework.data.repository.ListCrudRepository;

/**
 * A interface TransactionRepository é um repositório CRUD para transações.
 * Ela estende ListCrudRepository para fornecer operações CRUD para transações.
 */

public interface TransactionRepository extends ListCrudRepository<Transaction, Long> {

}
