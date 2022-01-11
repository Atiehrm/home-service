package ir.maktab.service;

import ir.maktab.data.dao.ManagerDao;
import lombok.Data;
import ir.maktab.data.model.entity.member.Manager;

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
