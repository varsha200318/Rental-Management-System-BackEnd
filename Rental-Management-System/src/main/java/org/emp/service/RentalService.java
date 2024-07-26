package org.emp.service;

import org.emp.dto.Customer;
import org.emp.dto.Rental;

import java.util.List;

public interface RentalService {
    void  addrental(Rental rental);
    List<Rental> getallrentals();

    void deleteRentalById(long id);
    void updateRental(Rental rental);

    Rental findbyid(Long id);
    Customer findbyrentaldate(Integer date);

}
