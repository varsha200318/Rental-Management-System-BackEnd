package org.emp.controller;

import lombok.RequiredArgsConstructor;
import org.emp.dto.Customer;
import org.emp.dto.Rental;
import org.emp.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental-controller")
@RequiredArgsConstructor
public class RentalController {
    final CustomerService service;
    @PostMapping("add-rental")
    @ResponseStatus(HttpStatus.CREATED)
    public  void addrental(@RequestBody Rental rental){

        service.addrental(rental);
    }
    @GetMapping("getall-rentals")
    public List<Rental> getallrental(){

        return service.getallrental();
    }
    @DeleteMapping("/delete-rental/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public  String deleteRental(Long id){
        service.deleteRentalById(id);
        return deleteRental(id);
    }
    @PostMapping("/update-rental")
    public void updateRental(@RequestBody Rental rental){

        service.updateRental(rental);
    }


}
