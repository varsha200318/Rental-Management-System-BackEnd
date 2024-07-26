package org.emp.repository;

import org.emp.entity.CustomerEntity;
import org.emp.entity.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<RentalEntity,Long> {

}

