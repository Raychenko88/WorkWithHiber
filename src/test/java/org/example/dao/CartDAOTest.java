package org.example.dao;

import org.example.models.Cart;
import org.example.models.User;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CartDAOTest {

    private CartDAO cartDAO = new CartDAO();
    private UserDAO userDAO = new UserDAO();
    @Test
    void saveAndGetAndDelete() {
        long currentTime = new Date().getTime();
        User user = new User("test_login", "test_pass", "test_fn", "test_ln");
        userDAO.save(user);
        User userFromDB = userDAO.findById(user.getId());

        Cart cart = new Cart(0, userFromDB.getId(), currentTime);
        cartDAO.save(cart);
        cart.setClosed(1);
        cartDAO.update(cart);
        Cart cartFromDB = cartDAO.findById(cart.getId());
        assertNotNull(cartFromDB);
        assertEquals(cart.getClosed(), cartFromDB.getClosed());

        cartDAO.delete(cart);
        assertNull(cartDAO.findById(cart.getId()));
        userDAO.delete(user);
    }
}