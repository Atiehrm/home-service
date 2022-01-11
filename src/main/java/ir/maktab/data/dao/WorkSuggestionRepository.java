package ir.maktab.data.dao;

import ir.maktab.util.HibernateUtil;
import ir.maktab.data.model.entity.WorkSuggestion;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author arm
 */
@Repository
public interface WorkSuggestionRepository extends CrudRepository<WorkSuggestion,Integer> {

}
