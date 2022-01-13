package ir.maktab.service;

import ir.maktab.data.model.entity.member.Expert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author arm
 */
public class GetOrderListTest {
    static ExpertService expertService;

    @BeforeAll
    static void init() {
        expertService = new ExpertService();
    }

    @Test
    void wheCallsGetOrderList_ThenReturnExpectedResponse() {
        Expert expert = expertService.findByEmail("atiehExpert@email.com");
        int result = expertService.getOrderList(expert).size();
        Assertions.assertEquals(1,result);
    }
}
