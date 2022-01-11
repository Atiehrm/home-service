package ir.maktab.dto;

import ir.maktab.data.model.entity.Address;
import ir.maktab.data.model.entity.WorkSuggestion;
import ir.maktab.data.model.entity.member.Customer;
import ir.maktab.data.model.entity.member.Expert;
import ir.maktab.data.model.enumeration.OrderState;
import lombok.Data;

import java.util.*;

/**
 * @author arm
 */
@Data
public class OrderDto {
    private int id;
    private long suggestedPrice;
    private long finalPrice;
    private Date registrationDate;
    private Customer customer;
    private Address address;
    private OrderState orderState;
    private Expert expert;
    private List<WorkSuggestion> workSuggestions = new ArrayList<>();


}
