package br.n2.picpay.desafio_pp_n2.transaction;

/**
 * A classe invalidTransactionException é uma exceção personalizada que é lançada quando uma transação é inválida.
 *
 * @param message Uma String que representa a mensagem da exceção.
 */


public class invalidTransactionException extends RuntimeException {
    public invalidTransactionException(String message) {
        super(message);
    }

}
