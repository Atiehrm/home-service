package ir.maktab.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author arm
 */
public class AddSubServiceToExpertTest {
    ExpertService expertService;

    @ParameterizedTest
    @CsvSource({"kitchen_design"})
    void givenWrongSubServiceName_whenCallsAddSubService_thenFalseResponse(String email, String name) {
        Exception exception = assertThrows(RuntimeException.class, () -> expertService
                .addSubServiceToExpertList(email, name));
        Assertions.assertEquals("sub service name is wrong", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"mahsaExpert@Gmail.com,barq"})
    void givenTrueSubServiceName_whenCallsAddSubService_thenTrueResponse(String email, String name) {
        expertService.addSubServiceToExpertList(email, name);
        Assertions.assertTrue(true);
    }

    @ParameterizedTest
    @CsvSource({"atiehExpert@gmail.com,kitchen_design"})
    void givenFalseExpert_whenCallsAddSubService_thenFalseResponse(String email, String name) {
        Exception exception = assertThrows(RuntimeException.class, () -> expertService
                .addSubServiceToExpertList(email, name));
        Assertions.assertEquals("expert email not found!", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"mahsaExpert@Gmail.com,barq"})
    void givenTrueExpert_whenCallsAddSubService_thenTrueResponse(String email, String name) {
        expertService.addSubServiceToExpertList(email, name);
        Assertions.assertTrue(true);
    }
}
