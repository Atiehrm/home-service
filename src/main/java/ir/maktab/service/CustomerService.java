package ir.maktab.service;

import ir.maktab.data.dao.*;
import ir.maktab.data.model.entity.Order;
import ir.maktab.data.model.entity.WorkSuggestion;
import ir.maktab.data.model.entity.member.Customer;
import ir.maktab.data.model.entity.member.Expert;
import ir.maktab.data.model.enumeration.OrderState;
import ir.maktab.data.model.enumeration.UserState;
import ir.maktab.exception.EmailException;
import ir.maktab.exception.EntityExistException;
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
        order.setOrderState(OrderState.PENDING_EXPERTS_SUGGESTION);
        orderDao.save(order);
    }

    public List<WorkSuggestion> getSuggestionListSortByScoreOrPrice(Order order, boolean byPrice, boolean byScoreExpert) {
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
        Optional<Expert> expert = expertDao.findById(expertId);
        if (order.isPresent()) {
            Order confirmedOrder = order.get();
            if (expert.isPresent()){
            Expert confirmedExpert = expert.get();
            confirmedOrder.setExpert(confirmedExpert);
            confirmedOrder.setOrderState(OrderState.PENDING_EXPERTS_IN_PLACE);
            orderDao.save(confirmedOrder);
        }else {
                throw new EntityExistException("expert not found!");
            }
        }
        else {
            throw new EntityExistException("order not found!");
        }
    }

    public Customer findByEmailAndPassword(String email, String password) {
        Optional<Customer> customer = customerDao.findByEmailAAndPassword(email, password);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            throw new RuntimeException("not found customer by this email and password");
        }
    }

    public List<Order> getListOrders(String email) {
        List<Order> ordersList;

        Optional<Customer> optionalCustomer = customerDao.findByEmail(email);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            ordersList = customerDao.getAllOrders(customer.getId());
        } else {
            throw new EntityExistException("not found customer by this email");
        }
        return ordersList;
    }

    public List<WorkSuggestion> getSuggestionList(Order order) {
        return orderDao.getWorkSuggestionList(order.getId());
    }
}
