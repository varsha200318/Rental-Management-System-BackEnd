package org.emp.service;

import org.emp.dto.Customer;
import org.emp.dto.Item;

import java.util.List;

public interface ItemService {
    void  addItem(Item item);
    List<Item> getallitem();

    void deleteItemById(long id);
    void updateItem(Item item);

   Item findbyid(Long id);
    Item findbyfirstName(String firstName);

}
