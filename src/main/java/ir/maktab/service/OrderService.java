package ir.maktab.service;

import ir.maktab.data.dao.OrderDao;
import lombok.Data;
import ir.maktab.data.model.entity.Order;

/**
 * @author arm
 */
@Data
public class OrderService {
    private OrderDao orderDao;

    public void save(Order order) {
        orderDao.save(order);
    }

    public void update(Order order) {
        orderDao.update(order);
    }
}
