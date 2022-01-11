package ir.maktab.service;

import ir.maktab.dao.WorkSuggestionDao;
import lombok.Data;
import ir.maktab.model.entity.WorkSuggestion;

/**
 * @author arm
 */
@Data
public class WorkSuggestionService {
    private WorkSuggestionDao workSuggestionDao;

    public void saveWorkSuggestion(WorkSuggestion workSuggestion) {
        workSuggestionDao.save(workSuggestion);
    }
}
