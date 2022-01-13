package ir.maktab.service;

import ir.maktab.data.dao.ExpertDao;
import ir.maktab.data.model.entity.member.Expert;
import ir.maktab.exception.EmailException;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author arm
 */
@Data
@Service
public class ExpertService {
    private ExpertDao expertDao;

    public void save(Expert expert) {
        expertDao.save(expert);
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
