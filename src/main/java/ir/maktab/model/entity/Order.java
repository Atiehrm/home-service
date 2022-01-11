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
import java.util.Date;
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
    @ManyToOne
    private SubService subService;
    @Enumerated(value = EnumType.STRING)
    private OrderState orderState;
    @CreationTimestamp
    private Date registrationDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date doneTime;
    @ManyToOne
    private Address address;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Customer customer;
    @ManyToOne
    private Expert expert;
    @OneToMany(mappedBy = "order")
    private Set<WorkSuggestion> workSuggestions = new HashSet<>();
}
