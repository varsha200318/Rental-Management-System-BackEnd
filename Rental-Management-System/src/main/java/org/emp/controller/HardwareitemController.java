package org.emp.controller;

import lombok.RequiredArgsConstructor;
import org.emp.dto.Customer;
import org.emp.dto.Item;
import org.emp.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Hardwareitem-controller")
@RequiredArgsConstructor
public class HardwareitemController {
    final ItemService service;

    @PostMapping("/add-item")
    @ResponseStatus(HttpStatus.CREATED)
    public  void addItem(@RequestBody Item item){

        service.addItem(item);
    }
    @GetMapping("getall-items")
    public List<Item> getallitems(){

        return service.getallitem();
    }
    @DeleteMapping("/delete-item/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public  String deleteItem(Long id){
        service.deleteItemById(id);
        return deleteItem(id);
    }
    @PostMapping("/update-item")
    public void updateitem(@RequestBody Item item){

        service.updateItem(item);
    }
    @GetMapping("/find-by-id/{id}")
    public Item findbyid(@PathVariable Long id) {

        return service.findbyid(id);
    }
    @GetMapping("/find-by-name/{firstName}")
    public Item findbfirstName(@PathVariable String firstName){
        return  service.findbyfirstName(firstName);
    }


}
