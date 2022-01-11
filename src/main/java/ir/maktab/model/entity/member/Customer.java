package ir.maktab.model.entity.member;

import ir.maktab.model.entity.Comment;
import ir.maktab.model.entity.Order;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author arm 1/5/2022
 */
@Entity
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Customer extends User {

    private long credit;
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();
    private Comment comment;
}
