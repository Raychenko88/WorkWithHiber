package org.example.dao;

import org.example.models.Cart;
import org.example.models.User;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CartDAOTest {

    @Test
    void saveAndGetAndDelete() {
        long currentTime = new Date().getTime();
        User user = new User("test_login", "test_pass", "test_fn", "test_ln");
        UserDAO.save(user);
        User userFromDB = UserDAO.findById(user.getId());

        Cart cart = new Cart(0, userFromDB.getId(), currentTime);
        CartDAO.save(cart);
        cart.setClosed(1);
        CartDAO.update(cart);
        Cart cartFromDB = CartDAO.findById(cart.getId());
        assertNotNull(cartFromDB);
        assertEquals(cart.getClosed(), cartFromDB.getClosed());

        CartDAO.delete(cart);
        assertNull(CartDAO.findById(cart.getId()));
        UserDAO.delete(user);
    }
}