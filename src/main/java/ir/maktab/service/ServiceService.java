package ir.maktab.service;

import ir.maktab.data.dao.ServiceDao;
import ir.maktab.data.model.entity.services.Service;
import ir.maktab.exception.EntityExistException;
import lombok.Data;

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

    public Service findByName(String name) {
        Optional<Service> service = serviceDao.findByName(name);
        if (service.isPresent()) {
            return service.get();
        } else {
            throw new EntityExistException("service not found!");
        }
    }
}
