package br.n2.picpay.desafio_pp_n2.authorization;

/**
 * A classe UnauthorizedTransactionException é uma exceção personalizada que é lançada quando uma transação não é autorizada.
 *
 * @param message Uma String que representa a mensagem da exceção.
 */

public class UnauthorizedTransactionException extends RuntimeException {

    public UnauthorizedTransactionException(String message) {
        super(message);
    }
}