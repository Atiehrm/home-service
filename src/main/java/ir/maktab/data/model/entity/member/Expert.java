package ir.maktab.data.model.entity.member;

import ir.maktab.data.model.entity.services.Service;
import ir.maktab.data.model.entity.services.SubService;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author arm 1/5/2022
 */
@Entity
@Data
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Expert extends User {
    @Lob
    @Column(nullable = false,columnDefinition = "BLOB",length = 300)
    private byte[] image;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<SubService> services = new ArrayList<>();
    private long credit;
    private double score;

}
