package custombank.project.user.service;

import custombank.project.user.entity.User;
import custombank.project.user.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        log.debug("Creating user in user service");
        return userRepository.save(user);
    }

    public User getUser(Long userId) {
        log.debug("Fetching user with id (in User service): " + userId.toString());
        return  userRepository.findByUserId(userId);
    }
}
