package com.sample.transactionapp.demo.service;

import com.sample.transactionapp.demo.exception.AccountNotFoundException;
import com.sample.transactionapp.demo.model.Account;
import com.sample.transactionapp.demo.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    @Autowired
    public AccountRepository accountRepository;

    public void transferMoney(Integer senderId, Integer recieveId, Integer amount) {
        Account senderAccount = accountRepository.findById(senderId)
                .orElseThrow(() -> new AccountNotFoundException(String.format("sender account: %s not found!", senderId)));

        Account recieverAccount = accountRepository.findById(senderId)
                .orElseThrow(() -> new AccountNotFoundException(String.format("recieve account: %s not found!", recieveId)));

        BigDecimal updatedSenderAmount = senderAccount.getAmount().subtract(new BigDecimal(amount));
        BigDecimal updatedReceiverAmount = recieverAccount.getAmount().add(new BigDecimal(amount));

        senderAccount.setAmount(updatedSenderAmount);
        recieverAccount.setAmount(updatedReceiverAmount);

        accountRepository.save(senderAccount);
        accountRepository.save(recieverAccount);
    }
}
