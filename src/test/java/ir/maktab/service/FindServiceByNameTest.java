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
public class FindServiceByNameTest {
    ServiceService serviceService;

    @BeforeEach
    void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);
        serviceService = (ServiceService) context.getBean("serviceService");
    }

    @ParameterizedTest
    @CsvSource({"wkiii"})
    void givenWrongServiceName_WhenFindServiceByNameCalls_ThenReturnFalseResponse(String name) {
        Exception exception = assertThrows(RuntimeException.class, () -> serviceService.findByName(name));
        Assertions.assertEquals("service not found!", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"internal design"})
    void givenTrueServiceName_WhenFindServiceByNameCalls_ThenReturnTrueResponse(String name) {
        serviceService.findByName(name);
        Assertions.assertTrue(true);
    }
}
