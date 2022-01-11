package ir.maktab.service;

import ir.maktab.data.dao.SubServiceDao;
import ir.maktab.exception.EntityExistException;
import lombok.Data;
import ir.maktab.data.model.entity.services.SubService;

import java.util.List;
import java.util.Optional;

/**
 * @author arm
 */
@Data
public class SubServiceService {
    private SubServiceDao subServiceDao;

    public List<SubService> getAllSubServiceName() {
        return subServiceDao.findAll();
    }

    public SubService findSubServiceByName(String name) {
        Optional<SubService> subService = subServiceDao.findByName(name);
        if (subService.isPresent()) {
            return subService.get();
        } else {
            throw new EntityExistException("subservice not found!");
        }
    }

    public void addNewSubService(SubService subService) {
        subServiceDao.save(subService);
    }
}
