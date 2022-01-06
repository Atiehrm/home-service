package ir.maktab.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author arm
 */
public class IsValidPasswordTest {

    @ParameterizedTest
    @CsvSource({"atiEh123", "Arm@45678"})
    void givenValidPassword_WhenIsValidPasswordCalls_ThenReturnTrueResponse(String password) {
        boolean result = ValidationUtil.isValidPassword(password);
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @CsvSource({"123", "abc"})
    void givenInvalidPassword_WhenIsValidPasswordCalls_ThenExceptionResponseReturn(String password) {
        Exception exception = assertThrows(RuntimeException.class, () ->
                ValidationUtil.isValidPassword(password));
        Assertions.assertEquals("not valid password", exception.getMessage());
    }
}
