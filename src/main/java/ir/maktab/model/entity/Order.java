package ir.maktab.model.entity;

import ir.maktab.model.entity.member.Customer;
import ir.maktab.model.entity.member.Expert;
import ir.maktab.model.entity.services.SubService;
import ir.maktab.model.enumeration.OrderState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

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
    private long suggestedPrice;
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
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
    @ManyToOne(cascade = CascadeType.ALL)
    private Expert expert;
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<WorkSuggestion> workSuggestions = new HashSet<>();
}
