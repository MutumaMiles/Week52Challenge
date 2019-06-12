package mutuma.com.week52challenge;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ValidAmountTest {

    @Test
    public void amountValidatorWithCorrectAmountReturnsTrue(){
        assertTrue(Utils.isValidAmount(200));
    }

    @Test
    public void amountValidatorWithInCorrectAmountReturnsFalse(){
        assertTrue(Utils.isValidAmount(2000000000));
    }
}
