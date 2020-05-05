package org.example.dao;

import org.example.factory.HibernateFactory;
import org.example.models.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OrderDAO {

    public static Order save(Order order){
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Integer id = (Integer) session.save(order);
        session.getTransaction().commit();
        session.close();
        order.setId(id);
        return order;
    }

    public static Order update(Order order){
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(order);
        session.getTransaction().commit();
        session.close();
        return order;
    }

    public static Order findById(Integer id){
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Order order = session.find(Order.class, id);
        session.getTransaction().commit();
        session.close();
        return order;
    }

    public static Order delete(Order order){
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(order);
        session.getTransaction().commit();
        session.close();
        return order;
    }
}
