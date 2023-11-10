package bloodllink.app.bloodlinkbackendapi.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;

import bloodllink.app.bloodlinkbackendapi.request.UserLoginRequest;
import bloodllink.app.bloodlinkbackendapi.service.UserService;

@RestController
public class UserLoginController {
	private final UserService userService;

	public UserLoginController(UserService userService) {
		super();
		this.userService = userService;
	}

    @PostMapping("/login")
	public String login(@RequestBody UserLoginRequest userLoginRequest) {
		String username = userLoginRequest.getUsername();
		String password = userLoginRequest.getPassword();

        if (userService.isValidUser(username, password)) {
            return "is a user";
        } else {
            return "invalid username or password";
        }
	}
}
