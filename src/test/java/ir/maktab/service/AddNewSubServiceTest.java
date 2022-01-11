package ir.maktab.service;

import ir.maktab.config.DatabaseConfig;
import ir.maktab.data.model.entity.services.Service;
import ir.maktab.data.model.entity.services.SubService;
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
public class AddNewSubServiceTest {
    SubServiceService subServiceService;
    SubService subService;
    Service service;

    @BeforeEach
    void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);
        subServiceService = (SubServiceService) context.getBean("subServiceService");
        subService = SubService.builder().service(service).name("kitchen facilities").build();

    }

    @ParameterizedTest
    @CsvSource({"facilities"})
    void givenWrongSubService_WhenAddSubServiceCalls_ThenReturnFalseResponse(String name) {
        Exception exception = assertThrows(RuntimeException.class, () -> subServiceService
                .addNewSubService(subService));
        Assertions.assertEquals("service of sub service is wrong", exception.getMessage());
    }
}
