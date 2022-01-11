package ir.maktab.data.model.entity;

import ir.maktab.data.model.entity.member.Expert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * @author arm 1/5/2022
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkSuggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreationTimestamp
    private Date creationDate;
    private long suggestedPrice;
    private long periodOfWorkTime; //minute
    @Temporal(TemporalType.TIME)
    private Date startingTime;
    @ManyToOne
    private Expert expert;
    @ManyToOne
    private Order order;

}
