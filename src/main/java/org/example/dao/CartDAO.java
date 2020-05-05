package org.example.dao;

import org.example.factory.HibernateFactory;
import org.example.models.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CartDAO {

    public static Cart save(Cart cart){
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Integer id = (Integer) session.save(cart);
        session.getTransaction().commit();
        session.close();
        cart.setId(id);
        return cart;
    }

    public static Cart update(Cart cart){
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(cart);
        session.getTransaction().commit();
        session.close();
        return cart;
    }

    public static Cart findById(Integer id){
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Cart cart = session.find(Cart.class, id);
        session.getTransaction().commit();
        session.close();
        return cart;
    }

    public static Cart delete(Cart cart){
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(cart);
        session.getTransaction().commit();
        session.close();
        return cart;
    }
}
