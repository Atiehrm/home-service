package ir.maktab.service;

import ir.maktab.data.dao.ServiceRepository;
import ir.maktab.data.model.entity.services.Service;
import ir.maktab.exception.EntityExistException;
import lombok.Data;

import java.util.Optional;

/**
 * @author arm
 */
@Data
public class ServiceService {
    private ServiceRepository serviceRepository;

    public void addService(Service service) {
        serviceRepository.save(service);
    }

    public Service findByName(String name) {
        Optional<Service> service = serviceRepository.findByName(name);
        if (service.isPresent()) {
            return service.get();
        } else {
            throw new EntityExistException("service not found!");
        }
    }
}
