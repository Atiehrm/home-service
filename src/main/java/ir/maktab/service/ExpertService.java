package ir.maktab.service;

import ir.maktab.dao.ExpertDao;
import ir.maktab.exception.EmailException;
import lombok.Data;
import ir.maktab.model.entity.member.Expert;

import java.util.Optional;

/**
 * @author arm
 */
@Data
public class ExpertService {
    private ExpertDao expertDao;

    public void save(Expert expert) {
        expertDao.save(expert);
    }

    public void update(Expert expert) {
        expertDao.update(expert);
    }

    public Expert findById(int id) {
        return expertDao.findById(id);
    }

    public Expert findByEmail(String email) {
        Optional<Expert> expert = expertDao.findByEmail(email);
        if (expert.isPresent()) {
            return expert.get();
        } else {
            throw new EmailException("expert email not found! ");
        }
    }
}
