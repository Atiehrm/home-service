package dao;

import config.HibernateUtil;
import model.entity.member.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author arm 1/5/2022
 */
public class UserDao {
    public void save(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }
    public User read(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User foundedUser = session.get(User.class, id);
        transaction.commit();
        session.close();
        return foundedUser;
    }

    public void delete(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(user);
        transaction.commit();
        session.close();
    }


}
