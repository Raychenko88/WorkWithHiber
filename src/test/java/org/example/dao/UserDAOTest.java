package org.example.dao;

import org.example.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    @Test
    void saveAndGetAndDelete(){
        User user = new User("test_login", "test_pass", "test_fn", "test_ln");
        UserDAO.save(user);
        user.setLogin("t_login");
        UserDAO.update(user);
        User userFromDB = UserDAO.findById(user.getId());
        assertNotNull(userFromDB);
        assertEquals(user.getLogin(), userFromDB.getLogin());

        UserDAO.delete(user);
        User userDeletedFromDB = UserDAO.findById(user.getId());
        assertNull(userDeletedFromDB);
    }
}