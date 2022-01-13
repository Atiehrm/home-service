package ir.maktab.data.dao;

import ir.maktab.data.model.entity.Order;
import ir.maktab.data.model.entity.member.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author arm 1/5/2022
 */
@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByEmailAAndPassword(String email,String password);

    @Query(value = "select o from  Customer c inner join c.orders o  where o.customer.id=:id")
    List<Order> getAllOrders(@Param("id") int customerId);
}
