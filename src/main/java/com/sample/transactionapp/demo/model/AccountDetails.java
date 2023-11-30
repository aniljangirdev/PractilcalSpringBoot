package com.sample.transactionapp.demo.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AccountDetails {

    @NotNull
    private String bankName;

    private String accountType;
}
