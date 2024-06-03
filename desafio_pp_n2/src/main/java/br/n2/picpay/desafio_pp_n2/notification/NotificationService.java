package br.n2.picpay.desafio_pp_n2.notification;

import org.springframework.stereotype.Service;

import br.n2.picpay.desafio_pp_n2.transaction.Transaction;

@Service
public class NotificationService {
    private final NotificationProducer notificationProducer;

    public NotificationService(NotificationProducer notificationProducer) {
        this.notificationProducer = notificationProducer;
    }

    public void notify(Transaction transaction) {
        notificationProducer.sendNotification(transaction);

    }
}

