package com.sample.transactionapp.demo.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Data
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer userId;

    private Boolean married;

    @NotNull
    private UserMetadata metadata;

    // TODO : need to be update with @CreatedTimeStamp
    private LocalDate createdOn = LocalDate.now();
}
