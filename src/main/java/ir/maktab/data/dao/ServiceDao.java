package ir.maktab.data.dao;

import ir.maktab.util.HibernateUtil;
import ir.maktab.data.model.entity.services.Service;
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
public interface ServiceDao extends CrudRepository<Service,Integer> {
    Optional<Service> findByName(String name);
}
