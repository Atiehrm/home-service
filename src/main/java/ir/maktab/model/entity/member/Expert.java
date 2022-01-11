package ir.maktab.model.entity.member;

import ir.maktab.model.entity.services.Service;
import ir.maktab.model.entity.services.SubService;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author arm 1/5/2022
 */
@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Expert extends User {
    @Lob
    @Column(nullable = false,columnDefinition = "BLOB",length = 300)
    private byte[] image;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Service> services = new ArrayList<>();
    private long credit;
    private double score;

}
