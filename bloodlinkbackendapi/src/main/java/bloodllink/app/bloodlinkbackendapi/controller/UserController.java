package bloodllink.app.bloodlinkbackendapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bloodllink.app.bloodlinkbackendapi.entity.Users;
import bloodllink.app.bloodlinkbackendapi.repository.UserRepo;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserRepo userRepo;
	@Autowired
	public UserController(UserRepo userRepo) {
		this.userRepo = userRepo;	
	}
	
	//read
	//this method fetch all the user list from the database table
	@GetMapping
	public List<Users> getAllUsers(){
		return userRepo.findAll();
	}
	
	//this method search user by id
	
	@GetMapping("/{user_id}")
	public Users getUserById (@PathVariable Long user_id) {
		return userRepo.findById(user_id).orElse(null);
	}
	
	//create
	
	// this method saves the data of a new user
	@PostMapping
	public Users createUser(@RequestBody Users user) {
		return userRepo.save(user);
		
	}
	//update
	
	//this method updates the data of a user by searching userid and then update the details
	@PutMapping("/{user_id}")
	public Users updateUser(@PathVariable Long user_id, @RequestBody Users user) {
		
		user.setUserId(user_id);
		return userRepo.save(user);
	}

	//delete
	
	//this method makes shadow delete the user	
	@PutMapping("/{user_id}")
	public Users deleteUser(@PathVariable Long user_id, @RequestBody Users user) {
		
		user.setDeleted(true);
		return userRepo.save(user);
	}
	
}
