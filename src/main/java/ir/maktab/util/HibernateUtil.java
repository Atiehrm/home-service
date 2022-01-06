package ir.maktab.util;

import ir.maktab.model.entity.Address;
import ir.maktab.model.entity.Order;
import ir.maktab.model.entity.WorkSuggestion;
import ir.maktab.model.entity.member.Customer;
import ir.maktab.model.entity.member.Expert;
import ir.maktab.model.entity.member.Manager;
import ir.maktab.model.entity.member.User;
import ir.maktab.model.entity.services.Service;
import ir.maktab.model.entity.services.SubService;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

/**
 * @author arm 1/5/2022
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                {
                    Configuration configuration = new org.hibernate.cfg.Configuration();
                    Properties setting = new Properties();
                    setting.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                    setting.put(Environment.URL, "jdbc:mysql://localhost:3306/homeservice");
                    setting.put(Environment.USER, "root");
                    setting.put(Environment.PASS, "root");
                    setting.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                    setting.put(Environment.SHOW_SQL, "true");
                    setting.put(Environment.FORMAT_SQL, "true");
                    setting.put(Environment.HBM2DDL_AUTO, "create");

                    configuration.setProperties(setting);
                    configuration.addAnnotatedClass(User.class);
                    configuration.addAnnotatedClass(Customer.class);
                    configuration.addAnnotatedClass(Manager.class);
                    configuration.addAnnotatedClass(Expert.class);
                    configuration.addAnnotatedClass(SubService.class);
                    configuration.addAnnotatedClass(Order.class);
                    configuration.addAnnotatedClass(Address.class);
                    configuration.addAnnotatedClass(Service.class);
                    configuration.addAnnotatedClass(WorkSuggestion.class);

                    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties()).build();
                    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}