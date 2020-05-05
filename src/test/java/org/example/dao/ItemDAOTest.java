package org.example.dao;

import org.example.models.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemDAOTest {

    @Test
    void saveAndGetAndDelete() {
        Item item = new Item("test_name", "t_code", 123, 1);
        ItemDAO.save(item);
        item.setCode("test_code");
        ItemDAO.update(item);
        Item itemFromDB = ItemDAO.findById(item.getId());
        assertNotNull(itemFromDB);
        assertEquals(item.getCode(), itemFromDB.getCode());

        ItemDAO.delete(item);
        assertNull(ItemDAO.findById(item.getId()));



    }
}