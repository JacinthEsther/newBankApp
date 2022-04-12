package com.BankApp.service;

import com.BankApp.data.model.Account;
import com.BankApp.dtos.request.CustomerRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest

class CustomerServiceTest {
    @Autowired
    CustomerService customerService;

    @Test
    void customerCanCreateAnAccount(){
        CustomerRequest customerNewAccount = new CustomerRequest();
        customerNewAccount.setFirstName("esther");
        customerNewAccount.setLastName("Jacinta");
        customerNewAccount.setBirthDate("13/04/2002");
        customerNewAccount.setEmailAddress("agbonirojacinta@gmail.com");
        customerNewAccount.setMobileNumber("09095861220");
        customerNewAccount.setPassword("Jacin8923_");
        customerNewAccount.setAccountType("SAVINGS");
        customerNewAccount.setBranchName("Pako");

        customerService.createAccount(customerNewAccount);
        assertThat(customerService.count(), is (1L));
    }

}