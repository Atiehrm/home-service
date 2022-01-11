package ir.maktab.dao;

import ir.maktab.util.HibernateUtil;
import ir.maktab.model.entity.member.Manager;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author arm 1/5/2022
 */
public class ManagerDao {

    public void save(Manager manager) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(manager);
        transaction.commit();
        session.close();
    }
}
