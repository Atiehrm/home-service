package service;

import dao.ManagerDao;
import lombok.Data;
import model.entity.member.Manager;

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
