package org.emp.controller;

import lombok.RequiredArgsConstructor;
import org.emp.dto.Customer;
import org.emp.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer-controller")
@RequiredArgsConstructor
public class CustomerController {
    final CustomerService service;
    @PostMapping("add-customer")
    @ResponseStatus(HttpStatus.CREATED)
    public  void addCustomer(@RequestBody Customer Customer){

        service.addCustomer(Customer);
    }
    @GetMapping("getall-customers")
    public List<Customer>getallcustomers(){
        return service.getallcustomers();
    }
   @DeleteMapping("/delete-customer/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public  String deleteCustomer(Long id){
        service.deleteCustomerById(id);
        return deleteCustomer(id);
   }
   @PostMapping("/update-customer")
    public void updateCustomer(@RequestBody Customer customer){
        service.updateCustomer(customer);
   }
   @GetMapping("/find-by-id/{id}")
    public Customer findbyid(@PathVariable Long id) {
       return service.findbyid(id);
   }
   @GetMapping("/find-by-name/{firstName}")
           public  Customer findbfirstName(@PathVariable String firstName){
       return  service.findbyfirstName(firstName);
       }
   }

