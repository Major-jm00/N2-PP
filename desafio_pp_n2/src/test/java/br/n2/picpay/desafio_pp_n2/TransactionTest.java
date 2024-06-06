package br.n2.picpay.desafio_pp_n2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import br.n2.picpay.desafio_pp_n2.transaction.Transaction;
import br.n2.picpay.desafio_pp_n2.wallet.Wallet;
import br.n2.picpay.desafio_pp_n2.wallet.WalletType;

// TODO: Auto-generated Javadoc
/**
 * The Class TransactionTest.
 */
public class TransactionTest {

    /**
     * Test constructor.
     */
    @Test
    public void testConstructor() {
        br.n2.picpay.desafio_pp_n2.transaction.Transaction transaction = new Transaction(1L, 2L, 3L, new BigDecimal("50.05"), LocalDateTime.now());
        
        assertEquals(new BigDecimal("50.05"), transaction.value());
    }

    /**
     * Test debit.
     */
    @Test
public void testDebit() {
    br.n2.picpay.desafio_pp_n2.wallet.Wallet wallet = new Wallet(1L, "John Doe", 123456789L, "john@example.com", "password", WalletType.COMUM.getValue(), new BigDecimal("100.00"));
    br.n2.picpay.desafio_pp_n2.transaction.Transaction transaction = new Transaction(1L, 2L, 3L, new BigDecimal("50.00"), LocalDateTime.now());
    
    br.n2.picpay.desafio_pp_n2.wallet.Wallet debitedWallet = wallet.debit(transaction.value());
    
    assertEquals(new BigDecimal("50.00"), debitedWallet.balance());
}

/**
 * Test credit.
 */
@Test
public void testCredit() {
    br.n2.picpay.desafio_pp_n2.wallet.Wallet wallet = new Wallet(1L, "John Doe", 123456789L, "john@example.com", "password", WalletType.COMUM.getValue(), new BigDecimal("100.00"));
    Transaction transaction = new Transaction(1L, 2L, 3L, new BigDecimal("50.00"), LocalDateTime.now());
    
    br.n2.picpay.desafio_pp_n2.wallet.Wallet creditedWallet = wallet.credit(transaction.value());
    
    assertEquals(new BigDecimal("150.00"), creditedWallet.balance());
}

}
