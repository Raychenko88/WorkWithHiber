package org.example.dao;

import org.example.factory.HibernateFactory;
import org.example.models.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ItemDAO {

    public static Item save(Item item) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Integer id = (Integer) session.save(item);
        session.getTransaction().commit();
        session.close();
        item.setId(id);
        return item;
    }

    public static Item update(Item item) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    public static Item findById(Integer id) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Item item = session.find(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    public static Item delete(Item item) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }
}
