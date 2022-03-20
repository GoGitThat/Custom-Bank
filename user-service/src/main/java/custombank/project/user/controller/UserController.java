package custombank.project.user.controller;

import custombank.project.user.entity.User;
import custombank.project.user.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Log4j2
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        log.debug("Creating user in User Controller");
        return userService.createUser(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId){
        log.debug("Fetching user with id (in User controller): " + userId.toString());
        return userService.getUser(userId);
    }
}
