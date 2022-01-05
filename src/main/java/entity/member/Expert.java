package entity.member;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import java.util.HashSet;

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
    private Set<SubServices> services = new HashSet<>();
    private long credit;

}
