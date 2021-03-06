package ir.maktab.model.entity;

import ir.maktab.model.entity.member.Expert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Calendar;

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
    private Calendar creationDateOfSuggestion;//short name
    private long suggestedPrice;
    private long periodOfWorkTime; //minute
    @Temporal(TemporalType.TIME)
    private Calendar startingWorkTime; //Date
    @ManyToOne
    private Expert expert;
    @ManyToOne
    private Order order;

}
