package service;

import dao.ServiceDao;
import lombok.Data;
import model.entity.services.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author arm
 */
@Data
public class ServiceService {
    private ServiceDao serviceDao;

    public boolean addService(Service service) {
        serviceDao.save(service);
        return true;
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
