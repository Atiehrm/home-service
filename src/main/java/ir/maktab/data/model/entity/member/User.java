package ir.maktab.data.model.entity.member;

import ir.maktab.data.model.enumeration.UserRole;
import ir.maktab.data.model.enumeration.UserState;
import ir.maktab.data.model.entity.Address;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author arm 1/5/2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@EqualsAndHashCode
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserState state;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date registerDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Address> addresses = new HashSet<>();
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;
}
