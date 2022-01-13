package ir.maktab.data.dao;

import ir.maktab.data.model.entity.member.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author arm
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);

    @Modifying
    @Query(value = "UPDATE User u set u.password =:password where u.id=:id")
    void updatePassword(@Param("email") String email, @Param("password") String password);

  /*  public int updatePassword(String email, String newPassword) {
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


    */

}
