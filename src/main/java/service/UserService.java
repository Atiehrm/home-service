package service;

import dao.UserDao;
import lombok.Data;
import model.entity.member.User;
import org.springframework.ui.ModelMap;

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
        userDao.update(user);
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
            throw new RuntimeException("email not exist!");
        }
    }

    public void changePassword(String email, String newPass) {
        Optional<User> foundedEmail = userDao.findByEmail(email);
        if (foundedEmail.isPresent()){
            userDao.updatePassword(email, newPass);
        }
        else {
            throw new RuntimeException("email not exist!");
        }
    }

}
