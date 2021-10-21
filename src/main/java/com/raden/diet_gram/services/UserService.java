package com.raden.diet_gram.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.raden.diet_gram.models.LoginUser;
import com.raden.diet_gram.models.User;
import com.raden.diet_gram.repositories.UserRepository;


@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
 // BOILER PLATE FOR REGISTERING A NEW USER W/ VALIDATION ...
    
    public User registerNewUser(User newUser, BindingResult result) {
        if(userRepository.findByEmail(newUser.getEmail()).isPresent()) {
            result.rejectValue("email", "Unique", "This email is already in use!");
        }
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepository.save(newUser);
        }
    }
    
    // BOILER PLATE FOR LOGGING IN A USER W/ VALIDATION ..
    
    public User login(LoginUser newLogin, BindingResult result) {
        if(result.hasErrors()) {
            return null;
        }
        Optional<User> potentialUser = userRepository.findByEmail(newLogin.getEmail());
        if(!potentialUser.isPresent()) {
            result.rejectValue("email", "Unique", "Unknown email!");
            return null;
        }
        User user = potentialUser.get();
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            return user;
        }
    }
    
    // GRAB THE USER MODEL BY ID
    
    public User findUserById(Long id) {   
    Optional<User> userByID = userRepository.findById(id);

 		if (userByID.isPresent()) {
 			return userByID.get();
 		} else {
 			return null;
 		
 		}
    }
    

	public User updateUser(User user) { 
		System.out.println(user.getConfirm());	
//		 String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
//        user.setPassword(hashed);
        return userRepository.save(user);
	   
		
	}
}
		
	
	
    
