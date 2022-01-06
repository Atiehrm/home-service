package dao;

import util.HibernateUtil;
import model.entity.services.Service;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author arm
 */
public class ServiceDao {

    public void save(Service service) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(service);
        transaction.commit();
        session.close();
    }

    public Service read(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Service service = session.get(Service.class, id);
        transaction.commit();
        session.close();
        return service;
    }

    public void update(Service service) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(service);
        transaction.commit();
        session.close();
    }

    public void delete(Service service) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(service);
        transaction.commit();
        session.close();
    }

    public Optional<Service> findByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Service service where service.name=:name";
        Query<Service> query = session.createQuery(hql, Service.class);
        query.setParameter("name", name);
        Optional<Service> service = Optional.ofNullable(query.uniqueResult());
        transaction.commit();
        session.close();
        return service;
    }

    public List<String> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "select service.name from Service service";
        Query<String> query = session.createQuery(hql, String.class);
        List<String> list = query.list();
        transaction.commit();
        session.close();
        return list;
    }
}
