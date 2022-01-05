package service;

import dao.SubServiceDao;
import lombok.Data;
import model.entity.services.SubService;

import java.awt.font.OpenType;
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
            throw new RuntimeException("subservice not found!");
        }
    }

    public void addNewSubService(SubService subService) {
        subServiceDao.save(subService);
    }
}
