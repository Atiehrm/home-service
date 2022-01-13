package ir.maktab.service;

import ir.maktab.data.dao.*;
import ir.maktab.data.model.entity.Order;
import ir.maktab.data.model.entity.WorkSuggestion;
import ir.maktab.data.model.entity.member.Expert;
import ir.maktab.data.model.entity.member.User;
import ir.maktab.data.model.entity.services.SubService;
import ir.maktab.data.model.enumeration.OrderState;
import ir.maktab.exception.EmailException;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author arm
 */
@Data
@NoArgsConstructor
@Service
public class ExpertService {
    ExpertDao expertDao;
    OrderDao orderDao;
    SubServiceDao subServiceDao;
    WorkSuggestionDao workSuggestionDao;
    CustomerDao customerDao;

    public ExpertService(ExpertDao expertDao, OrderDao orderDao, SubServiceDao subServiceDao
            , WorkSuggestionDao workSuggestionDao, CustomerDao customerDao) {
        this.expertDao = expertDao;
        this.orderDao = orderDao;
        this.subServiceDao = subServiceDao;
        this.workSuggestionDao = workSuggestionDao;
        this.customerDao = customerDao;
    }



    public void save(Expert expert) {
        expertDao.save(expert);
    }

    public Expert findByEmail(String email) {
        Optional<Expert> expert = expertDao.findByEmail(email);
        if (expert.isPresent()) {
            return expert.get();
        } else {
            throw new EmailException("expert email not found! ");
        }
    }
    public void addSubServiceToExpertList(String email, String subService) {
        Expert expert = findByEmail(email);
        Optional<SubService> subServicesOptional = subServiceDao.findByName(subService);
        if (subServicesOptional.isPresent() && expert != null) {
            SubService subServices = subServicesOptional.get();
            expert.getServices().add(subServices);
        } else {
            throw new RuntimeException("this subService not found");
        }
    }

    public void addSuggestionToOrder(String email, Order order, long price, long time, Date startTime) {
        Optional<Expert> expert = expertDao.findByEmail(email);
        if (expert.isPresent()) {
            Expert getExpert = expert.get();
            if (price > order.getSubService().getPrice()) {
                WorkSuggestion workSuggestion = WorkSuggestion.builder()
                        .suggestedPrice(price)
                        .startingTime(startTime)
                        .periodOfWorkTime(time)
                        .expert(getExpert)
                        .order(order)
                        .build();
                workSuggestionDao.save(workSuggestion);
                order.setOrderState(OrderState.PENDING_CHOOSE_EXPERT);
                orderDao.save(order);
            } else {
                throw new RuntimeException("price should be bigger than subService price");
            }
        }
    }

    public List<Order> getOrderList(Expert expert) {
        return orderDao.getOrderListForExpert(expert.getId());
    }
}
