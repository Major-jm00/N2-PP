package br.n2.picpay.desafio_pp_n2.transaction;

import java.util.List;


import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.n2.picpay.desafio_pp_n2.authorization.AuthorizerService;
import br.n2.picpay.desafio_pp_n2.notification.NotificationService;
import br.n2.picpay.desafio_pp_n2.wallet.Wallet;
import br.n2.picpay.desafio_pp_n2.wallet.WalletRepository;
import br.n2.picpay.desafio_pp_n2.wallet.WalletType;


/**
 * A classe TransactionService é responsável por gerenciar transações.
 * Ela contém métodos para criar e listar transações, bem como validar transações.
 *
 * @param transactionRepository O repositório de transações usado para salvar e recuperar transações.
 * @param walletRepository O repositório de carteiras usado para salvar e recuperar carteiras.
 * @param authorizerService O serviço de autorização usado para autorizar transações.
 * @param notificationService O serviço de notificação usado para notificar transações.
 */

@Service
public class TransactionService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);
    private final TransactionRepository transactionRepository;
    private final WalletRepository walletRepository;
    private final AuthorizerService authorizerService;
    private final NotificationService notificationService;

    /**
     * Construtor para a classe TransactionService.
     *
     * @param transactionRepository O repositório de transações usado para salvar e recuperar transações.
     * @param walletRepository O repositório de carteiras usado para salvar e recuperar carteiras.
     * @param authorizerService O serviço de autorização usado para autorizar transações.
     * @param notificationService O serviço de notificação usado para notificar transações.
     */
  
    public TransactionService(TransactionRepository transactionRepository,
        WalletRepository walletRepository, AuthorizerService authorizerService,
        NotificationService notificationService) {
      this.transactionRepository = transactionRepository;
      this.walletRepository = walletRepository;
      this.authorizerService = authorizerService;
      this.notificationService = notificationService;
    }


    /**
     * Cria uma nova transação.
     *
     * @param transaction A transação a ser criada.
     * @return A transação criada.
     * @throws InvalidTransactionException Se a transação for inválida.
     */
  
    @Transactional
    public Transaction create(Transaction transaction) {
      validate(transaction);
  
      var newTransaction = transactionRepository.save(transaction);
  
      var walletPayer = walletRepository.findById(transaction.payer()).get();
      var walletPayee = walletRepository.findById(transaction.payee()).get();
      walletRepository.save(walletPayer.debit(transaction.value()));
      walletRepository.save(walletPayee.credit(transaction.value()));
  
      authorizerService.authorize(transaction);
      notificationService.notify(newTransaction);
  
      return newTransaction;
    }
  
    /**
     * Valida uma transação.
     *
     * @param transaction A transação a ser validada.
     * @throws InvalidTransactionException Se a transação for inválida.
     */
 

     
    private void validate(Transaction transaction) {
      LOGGER.info("validating transaction {}...", transaction);
  
  walletRepository.findById(transaction.payee())
  .map(payee -> walletRepository.findById(transaction.payer())
  .map(payer -> payer.type() == WalletRepository.COMUM.getValue() &&
  payer.balance().compareTo(transaction.value()) >= 0 &&
  !payer.id().equals(transaction.payee()) ? true : null)

  .orElseThrow(() -> new InvalidTransactionException("Invalid transaction - "+ transaction))
  .orElseThrow(() ->  new InvalidTransactionException(
    "Invalid transaction - " + transaction));


    }

     /**
     * Verifica se uma transação é válida.
     *
     * @param transaction A transação a ser verificada.
     * @param payer A carteira do pagador.
     * @return true se a transação for válida, false caso contrário.
     */
    private boolean isTransactionValid(Transaction transaction, Wallet payer) {
      return payer.type() == WalletType.COMUM.getValue() &&
      payer.balance().compareTo(transaction.value()) >= 0 &&
      !payer.id().equals(transaction.payee());
    }

    /**
     * Lista todas as transações.
     *
     * @return Uma lista de todas as transações.
     */

    public List<Transaction> list() {
      return transactionRepository.findAll();
    }
 
    }

    
  