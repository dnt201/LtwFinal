package com.example.ltwnhom10.utl;

import java.util.Properties;

import com.example.ltwnhom10.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                //settings.put(Environment.URL, "jdbc:mysql://localhost:3306/nhom10?reconnect=true");
                settings.put(Environment.URL, "jdbc:mysql://103.81.84.22:3306/nhom10?reconnect=true");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "1234");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(UsersModel.class);
                configuration.addAnnotatedClass(RoleModel.class);
                configuration.addAnnotatedClass(DiscountModel.class);
                configuration.addAnnotatedClass(BrandModel.class);
                configuration.addAnnotatedClass(OrderDetailsModel.class);
                configuration.addAnnotatedClass(OrderItemsModel.class);
                configuration.addAnnotatedClass(ProductModel.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate Java Config serviceRegistry created");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
