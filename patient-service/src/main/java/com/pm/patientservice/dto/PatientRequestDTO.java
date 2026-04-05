package com.pm.patientservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {
    @NotBlank(message = "Name is Required")
    @Size(max=100, message = "Name cannot exceed 100 character")
    private String name;

    @NotBlank(message = "Address is Required")
    private String address;

    @NotBlank(message = "DOB is Required")
    private String dateOfBirth;

    @NotBlank(message = "Registered Date is Required")
    private String registeredDate;

    @NotBlank(message = "Email is Required")
    @Email(message = "Email should be valid")
    private String email;
}
