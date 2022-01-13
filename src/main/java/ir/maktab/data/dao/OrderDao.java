package ir.maktab.data.dao;

import ir.maktab.data.model.entity.Order;
import ir.maktab.data.model.entity.WorkSuggestion;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author arm
 */
@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {

    @Query(value = "select w from WorkSuggestion w inner join w.expert e inner join e.services s where w.order.id=:id")
    List<WorkSuggestion> getWorkSuggestionList(@Param("id") int ordersId);

    @Query(value = "select w from WorkSuggestion w inner join w.expert e inner join e.services s where w.order.id=:id")
    List<WorkSuggestion> getListWorkSuggestionsBySort(@Param("id") int ordersId, Sort sort);

    @Query(value = "from Order o where o.expert.id=:id")
    List<Order> getOrderListForExpert(@Param("id") int expertId);
}
