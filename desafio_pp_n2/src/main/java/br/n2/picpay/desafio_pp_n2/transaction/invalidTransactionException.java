package br.n2.picpay.desafio_pp_n2.transaction;

public class invalidTransactionException extends RuntimeException {
    public invalidTransactionException(String message) {
        super(message);
    }

}
