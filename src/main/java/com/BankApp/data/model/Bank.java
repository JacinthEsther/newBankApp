package com.BankApp.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document
public class Bank {
    @Id
    private String name;
    private ArrayList<Branch> branches = new ArrayList<>();
}
