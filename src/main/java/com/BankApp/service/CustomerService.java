package com.BankApp.service;


import com.BankApp.data.model.Customer;
import com.BankApp.dtos.request.CustomerRequest;
import com.BankApp.dtos.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    CustomerResponse createAccount(CustomerRequest request);
    List<Customer> getCustomersByBranchId(String branchId);
    long count();
}
