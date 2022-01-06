package ir.maktab.model.entity.member;

import ir.maktab.model.entity.Address;
import ir.maktab.model.enumeration.UserRole;
import ir.maktab.model.enumeration.UserState;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author arm 1/5/2022
 */
@Data
@NoArgsConstructor
@Entity
@SuperBuilder
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
    private Calendar registerDate;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Address> addresses = new ArrayList<>();
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;
}
