package br.n2.picpay.desafio_pp_n2;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import br.n2.picpay.desafio_pp_n2.authorization.AuthorizerService;
import br.n2.picpay.desafio_pp_n2.notification.NotificationService;
import br.n2.picpay.desafio_pp_n2.transaction.InvalidTransactionException;
import br.n2.picpay.desafio_pp_n2.transaction.Transaction;
import br.n2.picpay.desafio_pp_n2.transaction.TransactionRepository;
import br.n2.picpay.desafio_pp_n2.transaction.TransactionService;
import br.n2.picpay.desafio_pp_n2.wallet.Wallet;
import br.n2.picpay.desafio_pp_n2.wallet.WalletRepository;
import br.n2.picpay.desafio_pp_n2.wallet.WalletType;

// TODO: Auto-generated Javadoc
/**
 * The Class TransactionServiceTest.
 */
public class TransactionServiceTest {

    /**
     * Test validate invalid transaction.
     */
    @Test
    public void testValidateInvalidTransaction() {
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        WalletRepository walletRepository = mock(WalletRepository.class);
        AuthorizerService authorizerService = mock(AuthorizerService.class);
        NotificationService notificationService = mock(NotificationService.class);
        
        Wallet payerWallet = new Wallet(1L, "John Doe", 123456789L, "john@example.com", "password", WalletType.COMUM.getValue(), new BigDecimal("100.00"));
        Wallet payeeWallet = new Wallet(2L, "Jane Doe", 987654321L, "jane@example.com", "password", WalletType.COMUM.getValue(), new BigDecimal("100.00"));
        
        when(walletRepository.findById(1L)).thenReturn(Optional.of(payerWallet));
        when(walletRepository.findById(2L)).thenReturn(Optional.of(payeeWallet));
        
        Transaction invalidTransaction1 = new Transaction(1L, 1L, 1L, new BigDecimal("50.00"), LocalDateTime.now()); // payer and payee are the same
        Transaction invalidTransaction2 = new Transaction(1L, 2L, 3L, new BigDecimal("150.00"), LocalDateTime.now()); // payer does not have enough balance
        Transaction invalidTransaction3 = new Transaction(1L, 2L, 2L, new BigDecimal("50.00"), LocalDateTime.now()); // payer is the payee
        
        TransactionService transactionService = new TransactionService(transactionRepository, walletRepository, authorizerService, notificationService);
        
        assertThrows(InvalidTransactionException.class, () -> transactionService.validate(invalidTransaction1));
        assertThrows(InvalidTransactionException.class, () -> transactionService.validate(invalidTransaction2));
        assertThrows(InvalidTransactionException.class, () -> transactionService.validate(invalidTransaction3));
    }
}
