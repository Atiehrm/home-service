package ir.maktab.service;

import ir.maktab.data.model.entity.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author arm
 */
public class ChooseExpertForOrderTest {
    Order order;
    CustomerService customerService;

    @ParameterizedTest
    @CsvSource({"1,2"})
    void givenWrongOrderId_WhenChooseExpertForOrderCalls_ThenReturnFalseResponse(int orderId, int expertId) {
        Exception exception = assertThrows(RuntimeException.class, () -> customerService
                .chooseExpertForOrder(1, 2));
        Assertions.assertEquals("order not found!", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"1,1"})
    void givenTrueOrderIdAndExpertId_WhenChooseExpertForOrderCalls_ThenReturnTrueResponse
            (int orderId, int expertId) {
    customerService.chooseExpertForOrder(1, 1);
        Assertions.assertTrue(true);
    }

    @ParameterizedTest
    @CsvSource({"2,1"})
    void givenWrongExpertId_WhenChooseExpertForOrderCalls_ThenReturnFalseResponse(int orderId, int expertId) {
        Exception exception = assertThrows(RuntimeException.class, () -> customerService
                .chooseExpertForOrder(2, 1));
        Assertions.assertEquals("expert not found!", exception.getMessage());
    }
}
