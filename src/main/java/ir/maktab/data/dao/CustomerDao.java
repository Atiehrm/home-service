package ir.maktab.data.dao;

import ir.maktab.util.HibernateUtil;
import ir.maktab.data.model.entity.member.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Optional;

/**
 * @author arm 1/5/2022
 */
public class CustomerDao {

    public void save(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }

    public Optional<Customer> findByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query<Customer> query = session.createQuery("FROM Customer customer WHERE customer.email=:email");
        query.setParameter("email", email);
        Optional<Customer> customer = Optional.ofNullable(query.uniqueResult());
        transaction.commit();
        session.close();
        return customer;
    }

    public Customer findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        transaction.commit();
        session.close();
        return customer;
    }
}
