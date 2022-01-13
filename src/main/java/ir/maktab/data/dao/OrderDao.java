package ir.maktab.data.dao;

import ir.maktab.data.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author arm
 */
@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {
}
