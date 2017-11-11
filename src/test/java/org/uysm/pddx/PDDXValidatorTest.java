package org.uysm.pddx;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;

public class PDDXValidatorTest {

    String userId = "1";
    String password = "123456";
    String pddx = "1b7352f22302cf1b0d42422f21cc790c4f81ac8801a" +
            "938449cedd528dbe9e9b7d2160e670a6261bcd5164a5b21" +
            "64a89e98a34b54ccd59944ccc68fcc725f12ce374636791" +
            "9d55fa43101e0d2e1f2ff1c1c824499622e0643024f9d77bfebcbd2";

    @Test
    public void validate() throws NoSuchAlgorithmException {
        Boolean result = PDDXValidator.validate(pddx, userId, password);
        assertEquals(true, result);
    }
}