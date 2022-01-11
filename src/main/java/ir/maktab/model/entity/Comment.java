package ir.maktab.model.entity;

import ir.maktab.model.entity.member.Customer;
import ir.maktab.model.entity.member.Expert;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author arm
 */
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double score;
    private String comment;
 /*   private Expert expert;
    private Customer customer;*/
    @OneToOne
    private Order order;
}
