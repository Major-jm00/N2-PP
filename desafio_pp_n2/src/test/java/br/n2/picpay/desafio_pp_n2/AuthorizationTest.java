package br.n2.picpay.desafio_pp_n2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.n2.picpay.desafio_pp_n2.authorization.Authorization;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthorizationTest.
 */
public class AuthorizationTest {

    /**
     * Test is authorized returns true.
     */
    @Test
    public void testIsAuthorizedReturnsTrue() {
        Authorization authorization = new Authorization("Authorized");
        assertTrue(authorization.isAuthorized());
    }

    /**
     * Test is authorized returns false.
     */
    @Test
    public void testIsAuthorizedReturnsFalse() {
        Authorization authorization = new Authorization("NotAuthorized");
        assertFalse(authorization.isAuthorized());
    }
}
