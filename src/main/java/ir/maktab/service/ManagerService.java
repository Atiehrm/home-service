package ir.maktab.service;

import ir.maktab.data.dao.ManagerRepository;
import lombok.Data;
import ir.maktab.data.model.entity.member.Manager;

/**
 * @author arm
 */
@Data
public class ManagerService {
    private ManagerRepository managerRepository;

    public void save(Manager manager) {
        managerRepository.save(manager);
    }
}
