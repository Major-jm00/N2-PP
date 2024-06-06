package br.n2.picpay.desafio_pp_n2.notification;

import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import br.n2.picpay.desafio_pp_n2.transaction.Transaction;



/**
 * A classe NotificationConsumer é responsável por consumir notificações.
 * Ela usa um RestClient para fazer uma chamada GET e recuperar uma notificação.
 *
 * @param restClient Um RestClient usado para fazer chamadas GET.
 */
@Service
public class NotificationConsumer {
 private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(NotificationConsumer.class);

  private RestClient restClient;



  /**
   * Construtor para a classe NotificationConsumer.
   *
   * @param builder O construtor do RestClient.
   */
  public NotificationConsumer(RestClient.Builder builder) {
  this.restClient = builder
    .baseUrl("https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6")
    .build();
  }

   /**
   * Recebe uma notificação.
   *
   * @param transaction A transação a ser notificada.
   * @throws NotificationException Se houver um erro ao enviar a notificação.
   */

  @KafkaListener(topics = "transaction-notification", groupId = "picpay-desafio-backend")
  public void  receiveNotification(Transaction transaction ) {
    LOGGER.info("Notifying transaction: {}", transaction);;

  var response = restClient.get()
     .retrieve()
     .toEntity(Notification.class);

     if (response.getStatusCode().isError() || !response.getBody() .message())
     throw new  NotificationException("Error sending notification!");
   
     LOGGER.info("notification has been sent {}...", response.getBody());
      
  }

  }
