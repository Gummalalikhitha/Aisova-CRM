package com.aisova.crm.service;
import com.aisova.crm.dto.CustomerRequestDTO;
import com.aisova.crm.entity.Customer;
import com.aisova.crm.exception.CustomerNotFoundException;
import com.aisova.crm.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void createCustomer(CustomerRequestDTO dto) {
        if(repository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        Customer customer = new Customer();
        customer.setCustomerName(dto.getCustomerName());
        customer.setEmail(dto.getEmail());
        customer.setMobileNumber(dto.getMobileNumber());
        customer.setCompanyName(dto.getCompanyName());
        repository.save(customer);
    }

    public Customer updateCustomer(Long id, CustomerRequestDTO dto) {
        Customer customer = getCustomerById(id);
        customer.setCustomerName(dto.getCustomerName());
        customer.setEmail(dto.getEmail());
        customer.setMobileNumber(dto.getMobileNumber());
        customer.setCompanyName(dto.getCompanyName());
        return repository.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + id));
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public void deleteCustomer(Long id) {
        Customer customer = getCustomerById(id);
        repository.delete(customer);
    }

    public Customer searchCustomersByEmail(String email) {
        return repository.findByEmailContainingIgnoreCase(email).orElseThrow(() -> new CustomerNotFoundException("Customer not found with email: " + email));
    }
}