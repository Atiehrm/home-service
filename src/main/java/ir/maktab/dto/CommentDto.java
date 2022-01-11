package ir.maktab.dto;

import ir.maktab.data.model.entity.Order;
import ir.maktab.data.model.entity.member.Customer;
import ir.maktab.data.model.entity.member.Expert;
import lombok.Data;

/**
 * @author arm
 */
@Data
public class CommentDto {
    private int id;
    private String comment;
    private Customer customer;
    private Expert expert;
    private Order order;
}
