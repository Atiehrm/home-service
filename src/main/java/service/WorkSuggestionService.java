package service;

import dao.WorkSuggestionDao;
import lombok.Data;
import model.entity.WorkSuggestion;

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
