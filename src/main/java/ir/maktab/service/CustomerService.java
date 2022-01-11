package ir.maktab.service;

import ir.maktab.data.dao.CustomerRepository;
import ir.maktab.exception.EmailException;
import lombok.Data;
import ir.maktab.data.model.entity.member.Customer;

import java.util.Optional;

/**
 * @author arm
 */
@Data
public class CustomerService {
    private CustomerRepository customerRepository;

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer findByEmail(String email) {
        Optional<Customer> customer = customerRepository.findByEmail(email);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            throw new EmailException("customer email not exist!");
        }
    }
}
