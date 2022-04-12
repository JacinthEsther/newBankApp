package com.BankApp.service;

import com.BankApp.data.model.Account;
import com.BankApp.data.model.AccountType;
import com.BankApp.data.model.Customer;
import com.BankApp.data.repositories.CustomerRepository;
import com.BankApp.dtos.request.CustomerRequest;
import com.BankApp.dtos.response.CustomerResponse;
import com.BankApp.exceptions.InvalidMobileNumberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService{

    List<Customer> newCustomer = new ArrayList<>();
    @Autowired
    private CustomerRepository customers;
    String accountNumber = "";
    int id =0;

    @Override
    public CustomerResponse createAccount(CustomerRequest request) {
        Account account = new Account();
        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmailAddress(request.getEmailAddress());
        if(validateUserMobileNumber(request.getMobileNumber())) {
            customer.setMobileNumber(request.getMobileNumber());
        } else throw new InvalidMobileNumberException("enter a valid mobile number");
        customer.setBirthDate(request.getBirthDate());
        switch (request.getAccountType().toUpperCase()) {
            case "SAVINGS" -> account.setAccountType(AccountType.SAVINGS);
            case "CURRENT" -> account.setAccountType(AccountType.CURRENT);
            case "JOINT" -> account.setAccountType(AccountType.JOINT);
        }

        customer.setAccount(account);
       account.setAccountNumber(generateRandomAccountNumber());
       account.setAccountBalance(0.00);
        customer.setPassword(request.getPassword());
        newCustomer.add(customer);

        StringBuilder sb = new StringBuilder();
        Customer saveCustomer = customers.save(customer);
        CustomerResponse response = new CustomerResponse();
        response.setFullName(String.valueOf(sb.append(saveCustomer.getFirstName())
                .append(saveCustomer.getLastName())));
        response.setPassword(saveCustomer.getPassword());
        response.setAccountNumber(saveCustomer.getAccount().getAccountNumber());
        response.setTransactionAmount(0.00);
        response.setBvn(saveCustomer.getBvn());
        return response;
    }

    @Override
    public List<Customer> getCustomersByBranchId(String branchId) {
        List<Customer> customerx =  customers.findAll();
        customerx.stream().filter(cus -> cus.getBranch().getBranchId());
        return customerx;
    }

    private String generateRandomAccountNumber(){
        id++;
        accountNumber = "2211500"+ id;
        return accountNumber;
    }

    private boolean validateUserMobileNumber(String mobileNumber){
        return mobileNumber.length() == 11 || mobileNumber.length() == 14;
    }

    @Override
    public long count() {
        return newCustomer.size();
    }


}
