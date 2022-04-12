package com.BankApp.dtos.response;

import lombok.Data;

@Data
public class CustomerResponse {
    private String fullName;
    private String accountNumber;
    private String password;
    private double transactionAmount;
    private String bvn;
}
