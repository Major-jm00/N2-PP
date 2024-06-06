package br.n2.picpay.desafio_pp_n2.notification;


/**
 * A classe Notification é um registro que representa uma notificação.
 * Ela contém uma mensagem que indica o status da notificação.
 *
 * @param message Um booleano que representa a mensagem de notificação.
 */
public record Notification(
        boolean message) {

}