package ir.maktab.data.dao;

import ir.maktab.data.model.entity.services.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author arm
 */
@Repository
public interface ServiceDao extends JpaRepository<Service, Integer> {
    Optional<Service> findByName(String name);
}
