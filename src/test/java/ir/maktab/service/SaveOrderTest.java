package ir.maktab.service;

import ir.maktab.config.ServiceConfig;
import ir.maktab.model.entity.Order;
import ir.maktab.model.entity.services.SubService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author arm
 */
public class SaveOrderTest {
    OrderService orderService;
    Order order;
    SubService subService;

    @BeforeEach
    void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
        orderService = (OrderService) context.getBean("orderService");
        order = Order.builder().subService(subService).build();
    }

    @Test
    void givenTrueOrder_whenSaveOrderCall_ThenReturnTrueResponse() {
        orderService.save(order);//dto return
        Assertions.assertTrue(true);
    }

    @Test
    void givenOrderOnZeroSubService_whenSaveOrderCall_ThenReturnFalseResponse() {
        Exception exception = assertThrows(RuntimeException.class, () -> orderService.save(order));
        Assertions.assertEquals("sub service not exist!", exception.getMessage());
    }

}
