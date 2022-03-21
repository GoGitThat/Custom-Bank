package custombank.project.accountsservice.service;

import custombank.project.accountsservice.ValueObjects.UserAccounts;
import custombank.project.accountsservice.entity.Account;
import custombank.project.accountsservice.repository.AccountRepository;
import custombank.project.accountsservice.repository.AccountTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountTypesRepository accountTypesRepository;

    public Account createAccount(Account a){
        if (accountTypesRepository.existsById(a.getAccountType()) &&
                !accountRepository.existsByAccountTypeAndUserId(a.getAccountType(), a.getUserId())){
            return accountRepository.save(a);
        }
        return null;
    }

    public UserAccounts getUserFinAccounts(Long userId) {
        UserAccounts userAccounts = new UserAccounts();
        userAccounts.setListOfAccounts(accountRepository.findAllByUserId(userId));
        return userAccounts;
    }
}
