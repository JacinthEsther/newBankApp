package com.BankApp.data.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Document
public class Branch {
    @Id
    private int id;
    private String name;


    private List<Customer> customers = new ArrayList< Customer>();

    public Branch(String name) {
    this.name = name;
    }

    public String getName() {
        return name;
    }


}
