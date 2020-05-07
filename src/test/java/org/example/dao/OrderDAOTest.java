package org.example.dao;

import org.example.models.Cart;
import org.example.models.Item;
import org.example.models.Order;
import org.example.models.User;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OrderDAOTest {

    private OrderDAO orderDAO = new OrderDAO();
    private UserDAO userDAO = new UserDAO();
    private CartDAO cartDAO = new CartDAO();
    private ItemDAO itemDAO = new ItemDAO();

    @Test
    void saveAndGetAndDelete() {
        long currentTime = new Date().getTime();

        User user = new User("test_login", "test_pass", "test_fn", "test_ln");
        userDAO.save(user);
        User userFromDB = userDAO.findById(user.getId());

        Cart cart = new Cart(0, userFromDB.getId(), currentTime);
        cartDAO.save(cart);

        Item item = new Item("test_name", "t_code", 123, 1);
        itemDAO.save(item);

        Order order = new Order(item.getId(), cart.getId(), 10);
        orderDAO.save(order);
        order.setAmount(15);
        orderDAO.update(order);
        Order orderFromDB = orderDAO.findById(order.getId());
        assertNotNull(orderFromDB);
        assertEquals(order.getAmount(), orderFromDB.getAmount());

        orderDAO.delete(order);
        assertNull(orderDAO.findById(order.getId()));
        cartDAO.delete(cart);
        userDAO.delete(user);
    }
}