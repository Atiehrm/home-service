package dao;

import dto.UserDto;
import model.entity.member.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import util.HibernateUtil;
import util.filter.UserFilter;

import java.util.List;
import java.util.Optional;

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

    public void update(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(user);
        transaction.commit();
        session.close();
    }

    public List<User> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from  User ");
        List<User> userList = query.list();
        transaction.commit();
        session.close();
        return userList;
    }

    public Optional<User> findByEmailAndPass(String email, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from User u where u.email=:email and u.password=:password";
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        Optional<User> user = Optional.ofNullable(query.uniqueResult());
        transaction.commit();
        session.close();
        return user;
    }

    public int updatePassword(String email, String newPassword) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update Customer set password=:password where email=:email ");
        query.setParameter("email", email);
        query.setParameter("password", newPassword);
        int id = query.executeUpdate();
        transaction.commit();
        session.close();
        return id;
    }

    public Optional<User> findByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query<User> query = session.createQuery("FROM User u WHERE u.email=:email");
        query.setParameter("email", email);
        Optional<User> user = Optional.ofNullable(query.uniqueResult());
        transaction.commit();
        session.close();
        return user;
    }

    public List<UserDto> findUsersByFiltering(UserFilter filter) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class, "u");
        if (filter.getUserRole() != null) {
            criteria.add(Restrictions.eq("u.userRole", filter.getUserRole()));
        }
        if (filter.getFirstName() != null) {
            criteria.add(Restrictions.eq("u.firstName", filter.getFirstName()));
        }
        if (filter.getLastName() != null) {
            criteria.add(Restrictions.eq("u.lastName", filter.getLastName()));
        }
        if (filter.getRegisterDate() != null) {
            criteria.add(Restrictions.eq("u.registerDate", filter.getLastName()));

        }
        if (filter.getEmail() != null) {
            criteria.add(Restrictions.eq("u.email", filter.getEmail()));
        }

        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("u.registerDate").as("registerDate"))
                .add(Projections.property("u.userRole").as("userRole"))
                .add(Projections.property("u.firstName").as("firstName"))
                .add(Projections.property("u.lastName").as("lastName"))
                .add(Projections.property("u.email").as("email"))
                .add(Projections.property("u.userState").as("userState"))
                .add(Projections.property("u.id").as("id")));

        criteria.setResultTransformer(Transformers.aliasToBean(UserDto.class));
        List<UserDto> list = criteria.list();
        transaction.commit();
        session.close();
        return list;
    }

}
