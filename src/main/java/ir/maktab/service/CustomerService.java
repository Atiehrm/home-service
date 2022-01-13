package ir.maktab.service;

import ir.maktab.data.dao.*;
import ir.maktab.data.model.entity.Order;
import ir.maktab.data.model.entity.WorkSuggestion;
import ir.maktab.data.model.entity.member.Customer;
import ir.maktab.data.model.entity.member.Expert;
import ir.maktab.data.model.enumeration.OrderState;
import ir.maktab.data.model.enumeration.UserState;
import ir.maktab.exception.EmailException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author arm
 */
@Data
@Service
public class CustomerService {
    private CustomerDao customerDao;
    private OrderDao orderDao;
    private ServiceDao ServiceDao;
    private SubServiceDao subServices;
    private ExpertDao expertDao;
    private WorkSuggestionDao worksuggestionDao;

    @Autowired
    public CustomerService(CustomerDao customerDao, OrderDao orderDao, ServiceDao serviceDao
            , SubServiceDao subServices, ExpertDao expertDao, WorkSuggestionDao workSuggestionDao) {
        this.customerDao = customerDao;
        this.orderDao = orderDao;
        this.ServiceDao = serviceDao;
        this.subServices = subServices;
        this.expertDao = expertDao;
        this.worksuggestionDao = workSuggestionDao;
    }


    public void save(Customer customer) {

        if (customerDao.findByEmail(customer.getEmail()).isEmpty()) {
            customer.setState(UserState.PENDING);
            customerDao.save(customer);
        } else {
            throw new RuntimeException("not found user by this email");
        }
    }

    public Customer findByEmail(String email) {
        Optional<Customer> customer = customerDao.findByEmail(email);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            throw new EmailException("customer email not exist!");
        }
    }

    public void saveOrder(Order order) {
        double suggestedPrice = order.getSuggestedPrice();
        double finalPrice = order.getFinalPrice();
        if (finalPrice >= suggestedPrice) {
            order.setOrderState(OrderState.PENDING_EXPERTS_SUGGESTION);
            orderDao.save(order);
        } else {
            throw new RuntimeException("suggested price is bigger than final Price");
        }
    }

    public List<WorkSuggestion> getListOffersSortByScoreOrPrice(Order order, boolean byPrice, boolean byScoreExpert) {
        if (byPrice && !byScoreExpert) {
            return orderDao.getListWorkSuggestionsBySort(order.getId(), Sort.by("offerPrice").ascending());
        } else if (!byPrice && byScoreExpert) {
            return orderDao.getListWorkSuggestionsBySort(order.getId(), Sort.by("expert.score").descending());
        } else if (byPrice && byScoreExpert) {
            return orderDao.getListWorkSuggestionsBySort(order.getId(), Sort.by("expert.score").descending().and(Sort.by("offerPrice").ascending()));
        } else {
            return orderDao.getWorkSuggestionList(order.getId());
        }
    }

    public void chooseExpertForOrder(int orderId, int expertId) {
        Optional<Order> order = orderDao.findById(orderId);
        if (order.isPresent()) {
            Order confirmedOrder =order.get();
            Expert expert = expertDao.findById(expertId).get();
            confirmedOrder.setExpert(expert);
            confirmedOrder.setOrderState(OrderState.PENDING_EXPERTS_IN_PLACE);
            orderDao.save(confirmedOrder);
        }
    }
}
