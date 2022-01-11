package ir.maktab.service;

import ir.maktab.data.dao.WorkSuggestionRepository;
import lombok.Data;
import ir.maktab.data.model.entity.WorkSuggestion;
import org.springframework.stereotype.Service;

/**
 * @author arm
 */
@Data
@Service
public class WorkSuggestionService {
    private WorkSuggestionRepository workSuggestionRepository;

    public void saveWorkSuggestion(WorkSuggestion workSuggestion) {
        workSuggestionRepository.save(workSuggestion);
    }
}
