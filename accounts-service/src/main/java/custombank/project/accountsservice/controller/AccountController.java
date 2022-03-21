package custombank.project.accountsservice.controller;

import custombank.project.accountsservice.ValueObjects.UserAccounts;
import custombank.project.accountsservice.entity.Account;
import custombank.project.accountsservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @GetMapping("/{userId}")
    public UserAccounts getUserFinAccounts(@PathVariable Long userId){
        return accountService.getUserFinAccounts(userId);
    }
}
