package com.aisova.crm.controller;

import com.aisova.crm.dto.CustomerRequestDTO;
import com.aisova.crm.dto.MessageResponse;
import com.aisova.crm.entity.Customer;
import com.aisova.crm.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;


    @PostMapping
    public ResponseEntity<MessageResponse> createCustomer(@Valid @RequestBody CustomerRequestDTO request) {
        service.createCustomer(request);
        return new ResponseEntity<>(new MessageResponse("Customer Created Successfully"), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> listCustomers() {
        return ResponseEntity.ok(service.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCustomerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerRequestDTO request) {
        service.updateCustomer(id, request);
        return ResponseEntity.ok(new MessageResponse("Customer Updated Successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
        return ResponseEntity.ok(new MessageResponse("Customer Deleted Successfully"));
    }

    @GetMapping("/search")
    public ResponseEntity<Customer> searchCustomerByEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(service.searchCustomersByEmail(email));
    }
}