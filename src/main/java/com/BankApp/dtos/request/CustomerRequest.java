package com.BankApp.dtos.request;

import lombok.Data;

@Data
public class CustomerRequest {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String emailAddress;
    private String birthDate;
    private double initialAmount;
    private String password;
    private String accountType;
    private String branchName;
}
