package br.n2.picpay.desafio_pp_n2.authorization;

/**
 * A classe Authorization é um registro que representa uma autorização.
 * Ela contém uma mensagem que indica o status da autorização.
 *
 * @param message Uma String que representa a mensagem de autorização.
 */

public record Authorization(
    String message) {
    

        /**
     * Verifica se a autorização é válida.
     *
     * @return true se a mensagem for "Autorizado", false caso contrário.
     */

    public boolean isAuthorized() {
        return message.equals("Autorizado");
    

}

}