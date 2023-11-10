package bloodllink.app.bloodlinkbackendapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import bloodllink.app.bloodlinkbackendapi.request.UserRegistrationRequest;
import bloodllink.app.bloodlinkbackendapi.service.UserService;

public class UserRegistrationController {

    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    
    @PostMapping("/register")
    public String register(@RequestBody UserRegistrationRequest  UserregistrationRequest) {
        String username = UserregistrationRequest.getUsername();
        String password = UserregistrationRequest.getPassword();

        // Check if the username is available 
        if (userService.isValidUser(username, password)) {
            return "User is already exist";
        } else {   
        // Register the new user
        userService.RegisterUser(username, password);

        return "User registered successfully";
    }
    }
}
