package com.sample.transactionapp.demo.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class UserMetadata {

    @NotNull
    private String  name;

    @Range(min = 1, max = 99)
    private Integer age;

    // TODO : check why this validation is not working, and same like others
    @NotNull(message = "address is mendetory field")
    private String address;

    @NotNull
    private String phone;

    @NotNull
    private AccountDetails accountDetails;
}
