package org.example.dao;

import org.example.models.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemDAOTest {

    private ItemDAO itemDAO = new ItemDAO();

    @Test
    void saveAndGetAndDelete() {
        Item item = new Item("test_name", "t_code", 123, 1);
        itemDAO.save(item);
        item.setCode("test_code");
        itemDAO.update(item);
        Item itemFromDB = itemDAO.findById(item.getId());
        assertNotNull(itemFromDB);
        assertEquals(item.getCode(), itemFromDB.getCode());

        itemDAO.delete(item);
        assertNull(itemDAO.findById(item.getId()));



    }
}