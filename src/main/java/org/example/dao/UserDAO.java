package org.example.dao;

import org.example.factory.HibernateFactory;
import org.example.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDAO {

    public static User save(User user){
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Integer id = (Integer) session.save(user);
        session.getTransaction().commit();
        session.close();
        user.setId(id);
        return user;
    }

    public static User update(User user){
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
//        session.beginTransaction().begin();
        session.update(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public static User findById(Integer id){
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        User user = session.find(User.class,id);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public static User delete(User user){
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }
}
