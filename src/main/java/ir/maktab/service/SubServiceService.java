package ir.maktab.service;

import ir.maktab.data.dao.SubServiceRepository;
import ir.maktab.data.model.entity.services.SubService;
import ir.maktab.exception.EntityExistException;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author arm
 */
@Data
@Service
public class SubServiceService {
    private SubServiceRepository subServiceRepository;

/*
    public List<SubService> getAllSubServiceName() {
        return subServiceRepository.findAll();
    }
*/

    public SubService findSubServiceByName(String name) {
        Optional<SubService> subService = subServiceRepository.findByName(name);
        if (subService.isPresent()) {
            return subService.get();
        } else {
            throw new EntityExistException("subservice not found!");
        }
    }

    public void addNewSubService(SubService subService) {
        subServiceRepository.save(subService);
    }
}
