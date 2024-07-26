package org.emp.service;

import org.emp.dto.Customer;
import org.emp.dto.Rental;

import java.util.List;

public interface CustomerService {
void  addCustomer(Customer customer);
List<Customer>getallcustomers();

void deleteCustomerById(long id);
void updateCustomer(Customer customer);

Customer findbyid(Long id);
Customer findbyfirstName(String firstName);

    void addrental(Rental rental);

    List<Rental> getallrental();

    void deleteRentalById(Long id);

    void updateRental(Rental rental);
}
