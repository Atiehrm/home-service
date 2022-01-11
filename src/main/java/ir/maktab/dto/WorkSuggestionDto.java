package ir.maktab.dto;

import ir.maktab.data.model.entity.Order;
import ir.maktab.data.model.entity.member.Expert;
import lombok.Data;

import java.util.Date;

/**
 * @author arm
 */
@Data
public class WorkSuggestionDto {
    private int id;
    private Order order;
    private Expert expert;
    private Date creationDate;
    private long suggestedPrice;
    private long periodOfWorkTime;
    private Date startingTime;

}
