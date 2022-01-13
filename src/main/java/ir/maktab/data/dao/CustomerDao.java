package ir.maktab.data.dao;

import ir.maktab.data.model.entity.member.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author arm 1/5/2022
 */
@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer> {

    Optional<Customer> findByEmail(String email);
}
