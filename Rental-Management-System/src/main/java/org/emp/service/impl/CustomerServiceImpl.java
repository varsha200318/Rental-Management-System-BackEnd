package org.emp.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.emp.dto.Customer;
import org.emp.entity.CustomerEntity;
import org.emp.repository.CustomerRepository;
import org.emp.service.CustomerService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

final CustomerRepository repository;
@Override
public  void addCustomer(Customer customer){
    CustomerEntity customerEntity=new ObjectMapper().convertValue(customer,CustomerEntity.class);
    repository.save(customer);
}

    @Override
    public List<Customer> getallcustomers() {
    List<CustomerEntity> CustomerList=new ArrayList<>();
    List<CustomerEntity> allEntityList=repository.findAll();
    allEntityList.forEach(entity->{
        Customer customer=new ObjectMapper().convertValue(entity,Customer.class);
        CustomerList.add(customer);
    });
    return CustomerList;
    }

    @Override
    public void deleteCustomerById(long id) {
    if (repository.existsById(id)){
        repository.deleteById(id);
    }

    }

    @Override
    public void updateCustomer(Customer customer) {
    if (repository.findAllById(customer.getId()).ispresent()){
        repository.save(new ObjectMapper().convertValue(customer,CustomerEntity.class));
    }

    }

    @Override
    public Customer findbyid(Long id) {
    if(repository.findById(id).isPresent()){
        Optional<CustomerEntity> byId=repository.findById(id);
        return new ObjectMapper().convertValue(byId.get(), Customer.class);
    }
        return new Customer();
}

    @Override
    public Customer findbyfirstName(String firstName) {
        return  new ObjectMapper().convertValue(repository.findbyfirstname(firstName),Customer.class);

    }
}
