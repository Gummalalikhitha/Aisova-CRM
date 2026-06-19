package com.aisova.crm.repository;
import com.aisova.crm.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmailContainingIgnoreCase(String email);
    boolean existsByEmail(String email);
}