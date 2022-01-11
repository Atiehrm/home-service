package ir.maktab.service;

import ir.maktab.data.dao.OrderRepository;
import ir.maktab.data.model.entity.Order;
import lombok.Data;

/**
 * @author arm
 */
@Data
public class OrderService {
    private OrderRepository orderRepository;

    public void save(Order order) {
        orderRepository.save(order);
    }
}
