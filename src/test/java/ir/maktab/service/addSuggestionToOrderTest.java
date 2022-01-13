package ir.maktab.service;

import ir.maktab.data.model.entity.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author arm
 */
public class addSuggestionToOrderTest {
    ExpertService expertService;
    Order order = new Order();

    @BeforeEach
    void init() {
        order.getSubService().setPrice(5000);
    }

//ask how to add obj to csvsource
    @ParameterizedTest
    @CsvSource({"sara@gmail.com,order,3_000,8,1399-01-01"})
    void givenBiggerPriceThanSubServicePrice_whenCallsAddSuggestion_thenFalseResponse
            (String email, Order order, long price, long durationTime, Date startTime) {

        Exception exception = assertThrows(RuntimeException.class, () -> expertService
                .addSuggestionToOrder(email, order, price, durationTime, startTime));
        Assertions.assertEquals("price should be bigger than subService price",
                exception.getMessage());
    }
}
