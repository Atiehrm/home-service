package ir.maktab.service;

import ir.maktab.data.dao.UserDao;
import ir.maktab.data.model.enumeration.UserRole;
import ir.maktab.exception.EmailException;
import ir.maktab.exception.EntityExistException;
import ir.maktab.data.model.entity.member.User;
import lombok.Data;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author arm
 */
@Data
@Service
public class UserService {
    private UserDao userDao;

    public void save(User user) {
        userDao.save(user);
    }

    public void delete(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        if (userDao.findByEmailAndPassword(email, password).isPresent()) {
            userDao.delete(user);
        } else {
            throw new RuntimeException("user not exist!");
        }
    }

    public User findByEmailAndPass(String email, String password) {
        Optional<User> user = userDao.findByEmailAndPassword(email, password);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new EntityExistException("user not exist!");
        }
    }
    public List<User> findUserByCondition(String firstname, String lastname, String email, UserRole role) {
        Specification<User> specification = UserDao.selectByCondition(firstname, lastname, email, role);
        return userDao.findAll((Sort) specification);
    }
    public User findByEmail(String email) {
        Optional<User> user = userDao.findByEmail(email);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new EmailException(" user email not exist!");
        }
    }

    public void changePassword(String email, String newPass) {
        Optional<User> foundedEmail = userDao.findByEmail(email);
        if (foundedEmail.isPresent()) {
            userDao.updatePassword(email, newPass);
        } else {
            throw new EmailException("user email not exist!");
        }
    }

}
