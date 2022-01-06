package ir.maktab.service;

import ir.maktab.dao.UserDao;
import ir.maktab.model.entity.member.User;
import lombok.Data;

import java.util.Optional;

/**
 * @author arm
 */
@Data
public class UserService {
    private UserDao userDao;

    public void save(User user) {
        userDao.save(user);
    }

    public void update(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        if (userDao.findByEmailAndPass(email, password).isPresent())
            userDao.update(user);
    }

    public void delete(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        if (userDao.findByEmailAndPass(email, password).isPresent()){
            userDao.delete(user);
        }
        else {
            throw new RuntimeException("user not exist!");
        }
    }

    public User findByEmailAndPass(String email, String password) {
        Optional<User> user = userDao.findByEmailAndPass(email, password);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException("user not exist!");
        }
    }

    public User findByEmail(String email) {
        Optional<User> user = userDao.findByEmail(email);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException(" user email not exist!");
        }
    }

    public void changePassword(String email, String newPass) {
        Optional<User> foundedEmail = userDao.findByEmail(email);
        if (foundedEmail.isPresent()) {
            userDao.updatePassword(email, newPass);
        } else {
            throw new RuntimeException("user email not exist!");
        }
    }

}
