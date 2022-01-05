package model.entity.member;

import model.entity.services.SubService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * @author arm 1/5/2022
 */
@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Expert extends User{

    @Lob
    @Column(nullable = false)
    private byte[] image;
    @ManyToMany
    private Set<SubService> services = new HashSet<>();
    private long credit;

}
