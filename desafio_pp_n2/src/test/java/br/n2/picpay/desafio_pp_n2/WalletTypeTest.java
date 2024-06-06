package br.n2.picpay.desafio_pp_n2;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.n2.picpay.desafio_pp_n2.wallet.WalletType;

// TODO: Auto-generated Javadoc
/**
 * The Class WalletTypeTest.
 */
public class WalletTypeTest {

    /**
     * Test wallet type values.
     */
    @Test
    public void testWalletTypeValues() {
        assertEquals(1, WalletType.COMUM.getValue());
        assertEquals(2, WalletType.LOJISTA.getValue());
    }
}
