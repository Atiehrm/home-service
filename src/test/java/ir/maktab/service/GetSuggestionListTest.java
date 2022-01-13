package ir.maktab.service;

import ir.maktab.data.model.entity.Order;
import ir.maktab.data.model.entity.member.Customer;
import ir.maktab.data.model.entity.member.Expert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author arm
 */
public class GetSuggestionListTest {
    static CustomerService customerService;
    Order order;
    @BeforeAll
    static void init() {
        customerService = new CustomerService();

    }

    @Test
    void whenCallsGetSuggestionList_ThenReturnActualResponse() {
        int result = customerService.getSuggestionList(order).size();
        Assertions.assertEquals(1,result);
    }
}
