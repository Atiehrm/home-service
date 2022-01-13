package ir.maktab.data.dao;

import ir.maktab.data.model.entity.WorkSuggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author arm
 */
@Repository
public interface WorkSuggestionDao extends JpaRepository<WorkSuggestion, Integer> {

    List<WorkSuggestion> getListSuggestionByExpertId();

}
