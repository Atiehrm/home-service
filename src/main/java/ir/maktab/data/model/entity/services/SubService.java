package ir.maktab.data.model.entity.services;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author arm 1/5/2022
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SubService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;
    @ManyToOne
    private Service service;
    private long price;
    private String description;
}