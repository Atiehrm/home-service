package ir.maktab.service;

import ir.maktab.config.DatabaseConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author arm
 */
public class FindSubServiceByNameTest {
    SubServiceService subServiceService;


    @BeforeEach
    void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);
        subServiceService = (SubServiceService) context.getBean("subServiceService");
    }

    @ParameterizedTest
    @CsvSource({"sara"})
    void givenWrongSubServiceName_WhenFindSubServiceByNameCalls_ThenReturnFalseResponse(String name) {
        Exception exception = assertThrows(RuntimeException.class, () -> subServiceService
                .findSubServiceByName(name));
        Assertions.assertEquals("sub service name is wrong", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"kitchen design"})
    void givenTrueSubServiceName_WhenFindSubServiceByNameCalls_ThenReturnTrueResponse(String name) {
        subServiceService.findSubServiceByName(name);
        Assertions.assertTrue(true);
    }
}
