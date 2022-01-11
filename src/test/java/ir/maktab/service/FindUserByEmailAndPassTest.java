package ir.maktab.service;

import ir.maktab.config.DatabaseConfig;
import ir.maktab.data.model.entity.member.User;
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
public class FindUserByEmailAndPassTest {
    UserService userService;

    @BeforeEach
    void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);
        userService = (UserService) context.getBean("userService");
    }

    @ParameterizedTest
    @CsvSource({"Atieh.rahbari@gmail.com, Atieh09?2"})
    void givenTrueEmailAndPass_WhenFindByEmailAndPassCalls_ThenReturnTrueResponse(String email, String password) {
        User user = userService.findByEmailAndPass(email, password);
        Assertions.assertNotNull(user);
    }

    @ParameterizedTest
    @CsvSource({"Atieh.rahbari.gmail.com,234"})
    void givenWrongEmailAndPass_WhenFindByEmailAndPassCalls_ThenReturnFalseResponse(String email, String password) {
        Exception exception = assertThrows(RuntimeException.class, () ->
                userService.findByEmailAndPass(email, password));
        Assertions.assertEquals("user not exist!", exception.getMessage());
    }
}
