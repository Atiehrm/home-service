package ir.maktab.service;

import ir.maktab.data.dao.OrderRepository;
import ir.maktab.data.model.entity.Order;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author arm
 */
@Data
@Service
public class OrderService {
    private OrderRepository orderRepository;

    public void save(Order order) {
        orderRepository.save(order);
    }
}
