package org.example.dao;

import org.example.models.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class UserDAO extends BaseDAO<User>{


    public List<User> findByLogAndPass(String login, String password){

        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        String sql = "SELECT * FROM users WHERE login=:loginParam AND password=:passwordParam";
        Query<User> query = session.createNativeQuery(sql,User.class);
        query.setParameter("loginParam", login);
        query.setParameter("passwordParam", password);
        List<User> list = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public List<User> getAll(){
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        String sql = "SELECT * FROM users";
        Query<User> query = session.createNativeQuery(sql, User.class);
        List<User> list = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public  User getByLogin (String login){
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        String sql = "SELECT * FROM users WHERE login =:loginParam";
        Query<User> query = session.createNativeQuery(sql, User.class);
        query.setParameter("loginParam", login);
        User user = query.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return user;
    }
}
