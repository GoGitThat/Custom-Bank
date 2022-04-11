package custombank.project.accountsservice.service;

import custombank.project.accountsservice.ValueObjects.PlainAccountObject;
import custombank.project.accountsservice.ValueObjects.UserAccounts;
import custombank.project.accountsservice.entity.Account;
import custombank.project.accountsservice.repository.AccountRepository;
import custombank.project.accountsservice.repository.AccountTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountTypesRepository accountTypesRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Account createAccount(Account a){
        if (accountTypesRepository.existsById(a.getAccountType()) &&
                !accountRepository.existsByAccountTypeAndUserId(a.getAccountType(), a.getUserId())){
            return accountRepository.save(a);
        }
        return null;
    }

    public UserAccounts getUserFinAccounts(Long userId) {
        UserAccounts userAccounts = new UserAccounts();
        List<HashMap<String, PlainAccountObject>> accs = new LinkedList<>();
        accountRepository.findAllByUserId(userId).forEach(account -> {
            HashMap<String, PlainAccountObject> newAcc = new HashMap<>();
            PlainAccountObject pao = new PlainAccountObject();
            pao.setUserId(account.getUserId());
            pao.setAccountType(account.getAccountType());
            pao.setBalance(account.getBalance());
            pao.setFrozen(account.isFrozen());
            newAcc.put(account.getAccountTypes().getAccountDescription(), pao);
            accs.add(newAcc);
        });
        userAccounts.setListOfAccounts(accs);
        return userAccounts;
    }

    public boolean transactAmount(Long userId, BigDecimal amount, Integer accountType){
        Account userAccount = accountRepository.findByAccountTypeAndUserId(accountType, userId);
        if (userAccount.getBalance().compareTo(amount) > 0){
            userAccount.setBalance(userAccount.getBalance().subtract(amount));
            accountRepository.save(userAccount);
            return true;
        }
        return false;
    }

}
