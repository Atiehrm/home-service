package ir.maktab.service;

import ir.maktab.data.dao.CustomerDao;
import ir.maktab.exception.EmailException;
import lombok.Data;
import ir.maktab.data.model.entity.member.Customer;

import java.util.Optional;

/**
 * @author arm
 */
@Data
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
            throw new EmailException("customer email not exist!");
        }
    }

    public Customer findById(int id) {
        return customerDao.findById(id);
    }
}
