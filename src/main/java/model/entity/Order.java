package model.entity;

import model.entity.member.Customer;
import model.entity.member.Expert;
import model.entity.services.SubService;
import model.enumeration.OrderState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author arm 1/5/2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double suggestedPrice;
    private String requestDescription;
    @OneToOne
    private SubService subService;
    @Enumerated(value = EnumType.STRING)
    private OrderState orderState;
    @CreationTimestamp
    private Calendar registrationDate;
    @CreationTimestamp
    private Calendar doneTime;
    @OneToOne
    private Address address;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Expert expert;
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<WorkSuggestion> workSuggestions = new ArrayList<>();
}