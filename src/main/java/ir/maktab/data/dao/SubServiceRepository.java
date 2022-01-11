package ir.maktab.data.dao;

import ir.maktab.data.model.entity.services.SubService;
import ir.maktab.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author arm
 */
@Repository
public interface SubServiceRepository extends CrudRepository<SubService, Integer> {
    Optional<SubService> findByName(String name);

}
