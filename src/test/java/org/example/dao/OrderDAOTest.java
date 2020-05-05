package org.example.dao;

import org.example.models.Cart;
import org.example.models.Item;
import org.example.models.Order;
import org.example.models.User;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OrderDAOTest {

    @Test
    void saveAndGetAndDelete() {
        long currentTime = new Date().getTime();

        User user = new User("test_login", "test_pass", "test_fn", "test_ln");
        UserDAO.save(user);
        User userFromDB = UserDAO.findById(user.getId());

        Cart cart = new Cart(0, userFromDB.getId(), currentTime);
        CartDAO.save(cart);

        Item item = new Item("test_name", "t_code", 123, 1);
        ItemDAO.save(item);

        Order order = new Order(item.getId(), cart.getId(), 10);
        OrderDAO.save(order);
        order.setAmount(15);
        OrderDAO.update(order);
        Order orderFromDB = OrderDAO.findById(order.getId());
        assertNotNull(orderFromDB);
        assertEquals(order.getAmount(), orderFromDB.getAmount());

        OrderDAO.delete(order);
        assertNull(OrderDAO.findById(order.getId()));
        CartDAO.delete(cart);
        UserDAO.delete(user);
    }
}