package com.sample.transactionapp.demo.controller;

import com.sample.transactionapp.demo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/banking")
@RequiredArgsConstructor
public class AccountController {

    public final AccountService accountService;

    @PostMapping("/transfer{fromId}to{toId}")
    public ResponseEntity<Object> requestForTransferMoney(@PathVariable Integer fromId, @PathVariable Integer toId, @RequestParam Integer amount) {
        accountService.transferMoney(fromId, toId, amount);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok().body("\nWelcome");
    }

}
