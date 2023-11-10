package bloodllink.app.bloodlinkbackendapi.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import bloodllink.app.bloodlinkbackendapi.entity.UserEntity;
import bloodllink.app.bloodlinkbackendapi.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepo;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserService(UserRepository userRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userRepo = userRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public boolean isValidUser(String username, String password) {
		UserEntity user = userRepo.findByUsername(username);
		return user != null && bCryptPasswordEncoder.matches(password, user.getPassword());

	}
	public void RegisterUser(String username, String password) {
		
		//hashed the passwod i.e encrypt the password
		String hashedPassword = bCryptPasswordEncoder.encode(password);
		
		
		//save user with hashed password i.e with encrypt the password
		
		UserEntity newUser = new UserEntity(username, hashedPassword);
		
		//save user to database
		userRepo.save(newUser);
		
	}
}
