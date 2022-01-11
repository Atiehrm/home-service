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
public class ChangePasswordTest {
    UserService userService;

    @BeforeEach
    void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);
        userService = (UserService) context.getBean("userService");
    }


    @ParameterizedTest
    @CsvSource({"Atieh.rahbari@gmail.com, Atieh09?2"})
    void givenWrongUser_WhenChangePasswordCalls_ThenReturnFalseResponse(String email, String newPassword) {
        Exception exception = assertThrows(RuntimeException.class, () -> userService.changePassword(email, newPassword));
        Assertions.assertEquals("user email not exist!", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"Atieh@gmail.com, Atieh0912"})
    void givenSameOldPassword_WhenChangePasswordCalls_ThenReturnFalseResponse(String email, String newPassword) {
        Exception exception = assertThrows(RuntimeException.class, () -> userService.changePassword(email, newPassword));
        Assertions.assertEquals("password cant be like the old one", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"Atieh@gmail.com, Atieh"})
    void givenWrongPassword_WhenChangePasswordCalls_ThenReturnFalseResponse(String email, String newPassword) {
        Exception exception = assertThrows(RuntimeException.class, () -> userService.changePassword(email, newPassword));
        Assertions.assertEquals("password must be less than 8 chars,include uppercase,lowercase,no whitespace"
                , exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"Atieh@gmail.com, Atieh123"})
    void givenTruePassword_WhenChangePasswordCalls_ThenReturnTrueResponse(String email, String newPassword) {
        userService.changePassword(email, newPassword);
        Assertions.assertTrue(true);
    }
}
