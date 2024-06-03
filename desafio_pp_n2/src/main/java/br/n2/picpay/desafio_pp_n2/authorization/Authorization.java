package br.n2.picpay.desafio_pp_n2.authorization;

public record Authorization(
    String message) {
    

    public boolean isAuthorized() {
        return message.equals("Autorizado");
    

}

}