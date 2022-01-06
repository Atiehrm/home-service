package ir.maktab.service;

import ir.maktab.config.ServiceConfig;
import ir.maktab.model.entity.member.User;
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
public class FindByEmailTest {
    UserService userService;

    @BeforeEach
    void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
        userService = (UserService) context.getBean("userService");
    }

    @ParameterizedTest
    @CsvSource({"Atieh.rahbari@gmail.com"})
    void givenTrueEmail_WhenFindByEmailCalls_ThenReturnTrueResponse(String email) {
        User user = userService.findByEmail(email);
        Assertions.assertNotNull(user);
    }

    @ParameterizedTest
    @CsvSource({"Atieh.rahbari.gmail.com"})
    void givenWrongEmail_WhenFindByEmailCalls_ThenReturnFalseResponse(String email) {
        Exception exception = assertThrows(RuntimeException.class, () -> userService.findByEmail(email));
        Assertions.assertEquals("user email not exist!", exception.getMessage());
    }
}
