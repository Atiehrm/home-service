package ir.maktab.data.dao;

import ir.maktab.data.model.entity.WorkSuggestion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author arm
 */
@Repository
public interface WorkSuggestionDao extends CrudRepository<WorkSuggestion, Integer> {

}