package harmo.projects.controllers;

import harmo.projects.entities.AppUser;
import harmo.projects.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public AppUser register(@RequestBody AppUser user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody AppUser user){

        return userService.verify(user);
    }
}
