package dao;

import util.HibernateUtil;
import model.entity.WorkSuggestion;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author arm
 */
public class WorkSuggestionDao {

    public void save(WorkSuggestion workSuggestion) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(workSuggestion);
        session.saveOrUpdate(workSuggestion.getOrder());
        transaction.commit();
        session.close();
    }

    public WorkSuggestion read(WorkSuggestion workSuggestion) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        WorkSuggestion foundedWorkSuggestion = session.get(WorkSuggestion.class, workSuggestion.getId());
        transaction.commit();
        session.close();
        return foundedWorkSuggestion;
    }

    public void update(WorkSuggestion workSuggestion) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(workSuggestion);
        transaction.commit();
        session.close();
    }

    public void delete(WorkSuggestion workSuggestion) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(workSuggestion);
        transaction.commit();
        session.close();
    }
}
