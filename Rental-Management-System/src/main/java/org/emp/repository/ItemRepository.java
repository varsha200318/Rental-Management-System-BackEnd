package org.emp.repository;

import org.emp.entity.CustomerEntity;
import org.emp.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemRepository,Long> {
    ItemEntity findbyfirstname(String firstname);
}
