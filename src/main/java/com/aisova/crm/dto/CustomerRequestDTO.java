package com.aisova.crm.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class CustomerRequestDTO {

    @NotBlank(message = "Customer name is mandatory")
    private String customerName;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Mobile number is mandatory")
    @Size(min = 10, max = 10, message = "Mobile number length must be 10 digits")
    private String mobileNumber;

    @NotBlank(message = "Company name is mandatory")
    private String companyName;


}