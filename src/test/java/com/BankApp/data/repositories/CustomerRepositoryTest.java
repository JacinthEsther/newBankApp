package com.BankApp.data.repositories;

import com.BankApp.data.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class CustomerRepositoryTest {

        @Autowired
        CustomerRepository repository;

        @Test
        void customerCanCreateAnAccount(){
            Customer customer = new Customer("Esther","Jacinta","09095861220",
                    "agbonirojacinta@gmail.com","13/04/2009");

            Customer saveACustomer = repository.save(customer);
            assertNotNull(saveACustomer.getBvn());

            assertThat(saveACustomer.getBvn(), is(notNullValue()));
            assertThat(repository.count(), is(1L));
        }

    }

