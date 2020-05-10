package org.example.dao;

import org.example.models.Cart;
import org.example.models.Order;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class OrderDAO extends BaseDAO<Order> {

    public List<Order> getAllByCart(Cart cart) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        String sql = "SELECT * " +
                "FROM orders " +
                "WHERE cart_id=:id";
        Query<Order> query = session.createNativeQuery(sql, Order.class);
        query.setParameter("id", cart.getId());
        List<Order> list = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public Order updateAmount(Order order, Integer amount) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        String sql = "UPDATE orders SET " +
                "amount=:amountParam " +
                "WHERE id =:idParam";
        Query query = session.createNativeQuery(sql, Order.class);
        query.setParameter("amountParam", amount);
        query.setParameter("idParam", order.getId());
        query.executeUpdate();
        session.getTransaction().commit();
        order.setAmount(amount);
        session.close();
        return order;
    }

}
