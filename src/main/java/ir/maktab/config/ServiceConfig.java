package ir.maktab.config;

import ir.maktab.dao.*;
import ir.maktab.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import service.*;

/**
 * @author arm
 */
@Configuration
@Import(value = {DaoConfig.class})
public class ServiceConfig {
    @Bean
    public UserService userService(UserDao userDao) {
        UserService userService = new UserService();
        userService.setUserDao(userDao);
        return userService;
    }

    @Bean
    public CustomerService customerService(CustomerDao customerDao) {
        CustomerService customerService = new CustomerService();
        customerService.setCustomerDao(customerDao);
        return customerService;
    }

    @Bean
    public ManagerService managerService(ManagerDao managerDao) {
        ManagerService managerService = new ManagerService();
        managerService.setManagerDao(managerDao);
        return managerService;
    }

    @Bean
    public ExpertService expertService(ExpertDao expertDao) {
        ExpertService expertService = new ExpertService();
        expertService.setExpertDao(expertDao);
        return expertService;
    }

    @Bean
    public OrderService orderService(OrderDao orderDao) {
        OrderService orderService = new OrderService();
        orderService.setOrderDao(orderDao);
        return orderService;
    }

    @Bean
    public WorkSuggestionService workSuggestionService(WorkSuggestionDao suggestionDao) {
        WorkSuggestionService suggestionService = new WorkSuggestionService();
        suggestionService.setWorkSuggestionDao(suggestionDao);
        return suggestionService;
    }

    @Bean
    public ServiceService serviceService(ServiceDao serviceDao) {
        ServiceService serviceService = new ServiceService();
        serviceService.setServiceDao(serviceDao);
        return serviceService;
    }

    @Bean
    public SubServiceService subServiceService(SubServiceDao subServiceDao) {
        SubServiceService subServiceService = new SubServiceService();
        subServiceService.setSubServiceDao(subServiceDao);
        return subServiceService;
    }
}
