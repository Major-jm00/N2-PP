package br.n2.picpay.desafio_pp_n2.authorization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import br.n2.picpay.desafio_pp_n2.transaction.Transaction;

/**
 * A classe AuthorizerService é responsável por autorizar transações.
 * Ela usa um RestClient para fazer uma chamada GET e recuperar uma autorização.
 *
 * @param restClient Um RestClient usado para fazer chamadas GET.
 */


@Service
public class AuthorizerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizerService.class);
  private RestClient restClient;


  /**
     * Construtor para a classe AuthorizerService.
     *
     * @param builder O construtor do RestClient.
     */
  public AuthorizerService(RestClient.Builder builder) {
    this.restClient = builder.baseUrl(
        "https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc").build();
  }

/**
     * Autoriza uma transação.
     *
     * @param transaction A transação a ser autorizada.
     * @throws UnauthorizedTransactionException Se a transação não for autorizada.
     */

  public void authorize(Transaction transaction) {
    LOGGER.info("Authorizing transaction: {}", transaction);;

    

    var response = restClient.get().retrieve().toEntity(Authorization.class);
    if (response.getStatusCode().isError() || !response.getBody().isAuthorized())
      throw new UnauthorizedTransactionException("Unauthorized!");
  
      LOGGER.info("Transaction authorized: {}", transaction);;


      /**
 * A classe Authorization é um registro que representa uma autorização.
 * Ela contém uma mensagem que indica o status da autorização.
 *
 * @param message Uma String que representa a mensagem de autorização.
 */

  }
}

record Authorization(String message) {

   /**
     * Verifica se a autorização é válida.
     *
     * @return true se a mensagem for "Autorizado", false caso contrário.
     */
  public boolean isAuthorized() {
    return message.equals("Autorizado");
  }
}
    


