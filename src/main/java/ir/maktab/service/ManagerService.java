package ir.maktab.service;

import ir.maktab.dao.ManagerDao;
import lombok.Data;
import ir.maktab.model.entity.member.Manager;

/**
 * @author arm
 */
@Data
public class ManagerService {
    private ManagerDao managerDao;

    public void save(Manager manager) {
        managerDao.save(manager);
    }
}
