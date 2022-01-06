package ir.maktab.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author arm
 */
public class IsValidEmailTest {
    @ParameterizedTest
    @CsvSource({"atieh@gmail.com", "arm@yahoo.com"})
    void givenValidEmail_WhenIsValidEmailCalls_ThenReturnTrueResponse(String email) {
        boolean result = ValidationUtil.isValidEmail(email);
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @CsvSource({"@gmail.com", "a.gmail.com."})
    void givenInvalidEmail_WhenIsValidEmailCalls_ThenExceptionResponseReturn(String email) {
        Exception exception = assertThrows(RuntimeException.class, () ->
                ValidationUtil.isValidEmail(email));
        Assertions.assertEquals("email is not valid", exception.getMessage());
    }
}
