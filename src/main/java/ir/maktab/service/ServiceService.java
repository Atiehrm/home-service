package ir.maktab.service;

import ir.maktab.dao.ServiceDao;
import lombok.Data;
import ir.maktab.model.entity.services.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author arm
 */
@Data
public class ServiceService {
    private ServiceDao serviceDao;

    public void addService(Service service) {
        serviceDao.save(service);
    }

    public List<String> getAllServiceNames() {
        return serviceDao.getAll();
    }

    public Service findByName(String name) {
        Optional<Service> service = serviceDao.findByName(name);
        if (service.isPresent()) {
            return service.get();
        } else {
            throw new RuntimeException("service not found!");
        }
    }
}
