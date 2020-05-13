package org.example.dao;

import org.example.models.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    private UserDAO userDAO = new UserDAO();

    @Test
    void saveAndGetAndDeleteTest() {
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

    @Test
    void testFindByLogAndPassTest() {
        User user1 = new User("test_login1", "test_pass1", "test_fn", "test_ln");
        User user2 = new User("test_login2", "test_pass2", "test_fn", "test_ln");
        userDAO.save(user1);
        userDAO.save(user2);
        List<User> list = userDAO.findByLogAndPass(user1.getLogin(), user1.getPassword());
        assertNotNull(list);
        assertFalse(list.isEmpty());
        assertNotNull(list.get(0));
        assertEquals(list.get(0).getLogin(), user1.getLogin());

        userDAO.delete(user1);
        userDAO.delete(user2);
    }

    @Test
    void getAllTest() {
        User user1 = new User("test_login1", "test_pass1", "test_fn", "test_ln");
        User user2 = new User("test_login2", "test_pass2", "test_fn", "test_ln");
        userDAO.save(user1);
        userDAO.save(user2);
        List<User> list = userDAO.getAll();
        assertNotNull(list);
        assertFalse(list.isEmpty());
        userDAO.delete(user1);
        userDAO.delete(user2);
    }

    @Test
    void getByLoginTest() {
        User user1 = new User("test_login1", "test_pass1", "test_fn", "test_ln");
        userDAO.save(user1);
        List<User> list = userDAO.getByLogin(user1.getLogin());
        assertNotNull(list);
        assertFalse(list.isEmpty());
        assertEquals(user1.getLogin(), list.get(0).getLogin());
        userDAO.delete(user1);
    }

}