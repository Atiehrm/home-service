package dao;

import config.HibernateUtil;
import model.entity.member.Expert;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Optional;

/**
 * @author arm 1/5/2022
 */
public class ExpertDao {

    public void save(Expert expert) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(expert);
        transaction.commit();
        session.close();
    }

    public void update(Expert expert) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(expert);
        transaction.commit();
        session.close();
    }

    public Expert findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Expert expert = session.get(Expert.class, id);
        transaction.commit();
        session.close();
        return expert;
    }

    public Optional<Expert> findByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query<Expert> query = session.createQuery("FROM Expert expert WHERE expert.email=:email");
        query.setParameter("email", email);
        Optional<Expert> expert = Optional.ofNullable(query.uniqueResult());
        transaction.commit();
        session.close();
        return expert;
    }
}
