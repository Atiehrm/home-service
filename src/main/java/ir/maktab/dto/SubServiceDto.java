package ir.maktab.dto;

import ir.maktab.data.model.entity.services.Service;
import lombok.Data;

/**
 * @author arm
 */
@Data
public class SubServiceDto {
    private int id;
    private String name;
    private Service service;
    private long price;
    private String description;
}
