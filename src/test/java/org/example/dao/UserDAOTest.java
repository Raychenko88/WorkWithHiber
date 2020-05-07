package org.example.dao;

import org.example.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    private UserDAO userDAO = new UserDAO();

    @Test
    void saveAndGetAndDelete(){
        User user = new User("test_login", "test_pass", "test_fn", "test_ln");
        userDAO.save(user);
        user.setLogin("t_login");
        userDAO.update(user);
        User userFromDB = userDAO.findById(user.getId());
        assertNotNull(userFromDB);
        assertEquals(user.getLogin(), userFromDB.getLogin());

        userDAO.delete(user);
        User userDeletedFromDB = userDAO.findById(user.getId());
        assertNull(userDeletedFromDB);
    }
}