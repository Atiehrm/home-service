package entity;

import entity.member.Customer;
import entity.member.Expert;
import enumeration.OrderState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import java.util.Date;

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
    private Date registrationDate;
    @CreationTimestamp
    private Date doneTime;
    @OneToOne
    private Address address;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Expert expert;
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<Suggestion> suggestions = new HashSet<>();
}
