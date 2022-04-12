package com.BankApp.controller;

import com.BankApp.dtos.request.CustomerRequest;
import com.BankApp.dtos.response.ApiResponse;
import com.BankApp.dtos.response.CustomerResponse;
import com.BankApp.exceptions.InvalidMobileNumberException;
import com.BankApp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AccountRegistration {
    @Autowired
    CustomerService service;

    @PostMapping("/createAccount")
    public ResponseEntity<?> CustomerResponse(@RequestBody CustomerRequest createCustomerAccount){
     try{
       return new ResponseEntity<> (service.createAccount(createCustomerAccount), HttpStatus.CREATED) ;
     }
     catch(InvalidMobileNumberException ex){
         return new ResponseEntity<>(new ApiResponse(false,ex.getMessage()), HttpStatus.NO_CONTENT);
     }
    }
}
