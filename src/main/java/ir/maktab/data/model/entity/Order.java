package ir.maktab.data.model.entity;

import ir.maktab.data.model.entity.member.Customer;
import ir.maktab.data.model.entity.member.Expert;
import ir.maktab.data.model.entity.services.SubService;
import ir.maktab.data.model.enumeration.OrderState;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.*;

/**
 * @author arm 1/5/2022
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long suggestedPrice;
    private long finalPrice;
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
    private List<WorkSuggestion> workSuggestions = new ArrayList<>();
}
