package entity;

import entity.member.Expert;
import lombok.AllArgsConstructor;
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
public class WorkSuggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreationTimestamp
    private Calendar creationDateOfSuggestion;
    private long suggestedPrice;
    private int periodOfWorkTime;
    private Calendar startingWorkTime;
    @OneToOne
    private Expert expert;
    @ManyToOne
    private Order order;

}
