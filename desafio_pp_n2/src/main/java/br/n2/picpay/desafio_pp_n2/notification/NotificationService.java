package br.n2.picpay.desafio_pp_n2.notification;

import org.springframework.stereotype.Service;

import br.n2.picpay.desafio_pp_n2.transaction.Transaction;


/**
 * A classe NotificationService é responsável por notificar transações.
 * Ela usa um NotificationProducer para enviar a notificação.
 *
 * @param notificationProducer Um NotificationProducer usado para enviar notificações.
 */

@Service
public class NotificationService {
    private final NotificationProducer notificationProducer;


    /**
     * Construtor para a classe NotificationService.
     *
     * @param notificationProducer O NotificationProducer usado para enviar notificações.
     */

    public NotificationService(NotificationProducer notificationProducer) {
        this.notificationProducer = notificationProducer;
    }

    /**
     * Notifica uma transação.
     *
     * @param transaction A transação a ser notificada.
     */


    public void notify(Transaction transaction) {
        notificationProducer.sendNotification(transaction);

    }
}

