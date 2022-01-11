package ir.maktab.service;

import ir.maktab.config.ServiceConfig;
import ir.maktab.model.entity.member.User;
import ir.maktab.model.enumeration.UserRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author arm
 */
public class deleteUserTest {
    UserService userService;
    User user;

    @BeforeEach
    void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
        userService = (UserService) context.getBean("userService");
        user = User.builder().firstName("atie").lastName("rm").userRole(UserRole.CUSTOMER)
                .email("atieh@gmail.com").build();
    }

    @Test
    void givenWrongUser_WhenDeleteUserCalls_ThenReturnFalseResponse() {
        Exception exception = assertThrows(RuntimeException.class, () -> userService.delete(user));
        Assertions.assertEquals("user not exist!", exception.getMessage());
    }
}
