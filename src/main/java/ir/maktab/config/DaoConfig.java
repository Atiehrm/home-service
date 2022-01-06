package ir.maktab.config;

import ir.maktab.dao.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author arm
 */
@Configuration
public class DaoConfig {
    @Bean
    public UserDao userDao() {
        return new UserDao();
    }

    @Bean
    public CustomerDao customerDao() {
        return new CustomerDao();
    }

    @Bean
    public ExpertDao expertDao() {
        return new ExpertDao();
    }

    @Bean
    public ManagerDao managerDao() {
        return new ManagerDao();
    }

    @Bean
    public ServiceDao serviceDao() {
        return new ServiceDao();
    }

    @Bean
    public SubServiceDao subServiceDao() {
        return new SubServiceDao();
    }

    @Bean
    public OrderDao orderDao() {
        return new OrderDao();
    }

    @Bean
    public WorkSuggestionDao workSuggestionDao() {
        return new WorkSuggestionDao();
    }
}
