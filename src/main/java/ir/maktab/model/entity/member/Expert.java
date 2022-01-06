package ir.maktab.model.entity.member;

import ir.maktab.model.entity.services.SubService;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author arm 1/5/2022
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Expert extends User {
    @Lob
    @Column(nullable = false)
    private byte[] image;
    @ManyToMany
    private List<SubService> services = new ArrayList<>();
    private long credit;

}
