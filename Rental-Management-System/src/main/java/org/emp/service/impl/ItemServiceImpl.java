package org.emp.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.emp.dto.Customer;
import org.emp.dto.Item;
import org.emp.entity.CustomerEntity;
import org.emp.entity.ItemEntity;
import org.emp.repository.ItemRepository;
import org.emp.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {
    final ItemRepository repository;
    @Override
    public void addItem(Item item) {
        ItemEntity itemEntity=new ObjectMapper().convertValue(item,ItemEntity.class);
        repository.save(item);
    }

    @Override
    public List<Item> getallitem() {
        List<ItemEntity> ItemList=new ArrayList<>();
        List<ItemEntity> allEntityList=repository.findAll();
        allEntityList.forEach(entity->{
            Item item=new ObjectMapper().convertValue(entity,Item.class);
            ItemList.add(item);
        });
        return ItemList;
    }


    @Override
    public void deleteItemById(long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
        }
    }

    @Override
    public void updateItem(Item item) {
        if (repository.findAllById(item.getId()).ispresent()){
            repository.save(new ObjectMapper().convertValue(item,ItemEntity.class));
        }
    }

    @Override
    public Item findbyid(Long id) {
        if(repository.findById(id).isPresent()){
            Optional<ItemEntity> byId=repository.findById(id);
            return new ObjectMapper().convertValue(byId.get(),Item.class);
        }
        return new Item();
    }


    @Override
    public Item findbyfirstName(String firstName) {
        return  new ObjectMapper().convertValue(repository.findbyfirstname(firstName),Item.class);

    }
    }

