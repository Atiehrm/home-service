package model.entity.services;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author arm 1/5/2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "service", fetch = FetchType.EAGER)
    private Set<SubService> subServices = new HashSet<>();
}