package com.BankApp.data.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Document("Customer")
public class Customer {

     @Id
    private String bvn;
     @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String mobileNumber;
    @NonNull
    private String emailAddress;
    @NonNull
    private String birthDate;
    private Account account;
    private String password;
}
