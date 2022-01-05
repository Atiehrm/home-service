package service;

import dao.CustomerDao;
import model.entity.member.Customer;
import model.entity.member.User;

import java.util.Optional;

/**
 * @author arm
 */
public class CustomerService {
    private CustomerDao customerDao;

    public void save(Customer customer) {
        customerDao.save(customer);
    }

    public Customer findByEmail(String email) {
        Optional<Customer> customer = customerDao.findByEmail(email);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            throw new RuntimeException("email not exist!");
        }
    }

    public Customer findById(int id) {
        return customerDao.findById(id);
    }
}
