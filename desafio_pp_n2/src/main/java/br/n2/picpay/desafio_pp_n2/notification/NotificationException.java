package br.n2.picpay.desafio_pp_n2.notification;


/**
 * A classe NotificationException é uma exceção personalizada que é lançada quando há um erro ao enviar uma notificação.
 *
 * @param message Uma String que representa a mensagem da exceção.
 */
public class NotificationException extends RuntimeException {

    public NotificationException(String message){
    super(message);
}
}
