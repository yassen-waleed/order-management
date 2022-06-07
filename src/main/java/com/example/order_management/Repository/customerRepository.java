package com.example.order_management.Repository;

import com.example.order_management.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface customerRepository extends JpaRepository<Customer,Long> {


    Optional<Customer> findByEmail(String username);}
