package custombank.project.user.service;

import custombank.project.user.ValueObjects.Account;
import custombank.project.user.ValueObjects.UserAccounts;
import custombank.project.user.ValueObjects.UserAccountsResponseTemplate;
import custombank.project.user.entity.User;
import custombank.project.user.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Log4j2
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User createUser(User user) {
        log.debug("Creating user in user service");
        return userRepository.save(user);
    }

    public User getUser(Long userId) {
        log.debug("Fetching user with id (in User service): " + userId.toString());
        return  userRepository.findByUserId(userId);
    }

    public UserAccountsResponseTemplate getUserFinAccounts(Long userId) {
        UserAccountsResponseTemplate newResponse = new UserAccountsResponseTemplate();
        UserAccounts listOfAccounts =
                restTemplate.getForObject("http://localhost:9002/accounts/"+userId.toString(), UserAccounts.class);
        newResponse.setAccountList(listOfAccounts);
        newResponse.setUser(userRepository.findByUserId(userId));
        return newResponse;
    }
}
