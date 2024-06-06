package br.n2.picpay.desafio_pp_n2.notification;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.n2.picpay.desafio_pp_n2.transaction.Transaction;

/**
 * A classe NotificationProducer é responsável por produzir notificações.
 * Ela usa um KafkaTemplate para enviar uma transação para um tópico Kafka.
 *
 * @param kafkaTemplate Um KafkaTemplate usado para enviar transações.
 */


@Service
public class NotificationProducer {
    private final KafkaTemplate<String, Transaction> kafkaTemplate;

     /**
     * Construtor para a classe NotificationProducer.
     *
     * @param kafkaTemplate O KafkaTemplate usado para enviar transações.
     */
    public NotificationProducer(KafkaTemplate<String, Transaction> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Envia uma notificação.
     *
     * @param transaction A transação a ser notificada.
     */
    
    public void sendNotification(Transaction transaction) {
        kafkaTemplate.send("transaction-notification", transaction);
    }
}