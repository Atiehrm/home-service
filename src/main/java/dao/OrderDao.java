package dao;

import config.HibernateUtil;
import model.entity.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author arm
 */
public class OrderDao {

    public void save(Order order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(order);
        session.saveOrUpdate(order.getCustomer());
        transaction.commit();
        session.close();
    }

    public Order read(Order order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Order foundedOrder = session.get(Order.class, order.getId());
        transaction.commit();
        session.close();
        return foundedOrder;
    }

    public void update(Order order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(order);
        transaction.commit();
        session.close();
    }

    public void delete(Order order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(order);
        transaction.commit();
        session.close();
    }

}
