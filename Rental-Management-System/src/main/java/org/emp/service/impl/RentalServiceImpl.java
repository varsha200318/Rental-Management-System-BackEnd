package org.emp.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.emp.dto.Customer;
import org.emp.dto.Rental;
import org.emp.entity.CustomerEntity;
import org.emp.entity.RentalEntity;
import org.emp.repository.CustomerRepository;
import org.emp.repository.RentalRepository;
import org.emp.service.RentalService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {
    final RentalRepository repository;
    @Override
    public void addrental(Rental rental) {
        RentalEntity rentalEntity=new ObjectMapper().convertValue(rental,RentalEntity.class);
        repository.save(rental);
    }

    @Override
    public List<Rental> getallrental() {
        List<RentalEntity>RentalList=new ArrayList<>();
        List<RentalEntity> allEntityList=repository.findAll();
        allEntityList.forEach(entity->{
           Rental rental=new ObjectMapper().convertValue(entity,Rental.class);
            RentalList.add(RentalEntity);
        });
        return RentalList;
    }

    @Override
    public void deleteRentalById(long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
    }

    @Override
    public void updateRental(Rental rental){
            if (repository.findAllById(rental.getId()).ispresent()) {
                repository.save(new ObjectMapper().convertValue(rental, RentalEntity.class));
            }



        }