package com.sample.transactionapp.demo.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ErrorDetails {

    // TODO : need to be update with @CreatedTimeStamp
    private String timestamp = LocalDate.now().toString();

    private String message;
}
