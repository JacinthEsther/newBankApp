package com.BankApp.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Account {
    @Id
    private int id;
    private double accountBalance;
    private String accountNumber;
     AccountType accountType = AccountType.SAVINGS;
}
