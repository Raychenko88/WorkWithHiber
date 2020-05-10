package org.example.dao;

import org.example.factory.HibernateFactory;
import org.example.models.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.lang.reflect.ParameterizedType;

public abstract class BaseDAO<T extends BaseEntity> {

    private Class<T> type;
    protected SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

    public BaseDAO(){
        type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T save(T entity) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Integer id = (Integer) session.save(entity);
        entity.setId(id);
        session.getTransaction().commit();
        session.close();

        return entity;
    }

    public T update(T entity) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    public T findById(Integer id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        T entity = session.find(type, id);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    public void delete(T entity) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }
}
