package ir.maktab.service;

import ir.maktab.data.dao.ExpertRepository;
import ir.maktab.data.model.entity.member.Expert;
import ir.maktab.exception.EmailException;
import lombok.Data;

import java.util.Optional;

/**
 * @author arm
 */
@Data
public class ExpertService {
    private ExpertRepository expertRepository;

    public void save(Expert expert) {
        expertRepository.save(expert);
    }

    public Expert findByEmail(String email) {
        Optional<Expert> expert = expertRepository.findByEmail(email);
        if (expert.isPresent()) {
            return expert.get();
        } else {
            throw new EmailException("expert email not found! ");
        }
    }
}
