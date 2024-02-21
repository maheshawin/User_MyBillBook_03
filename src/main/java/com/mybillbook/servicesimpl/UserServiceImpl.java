package com.mybillbook.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybillbook.entities.User;
import com.mybillbook.exceptions.UserNotFoundException;
import com.mybillbook.repositories.UserRepository;
import com.mybillbook.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public String createUser(User user) {
		userRepository.save(user);
		return "User Creted";
	}

	@Override
	public String updateUser(User user) throws UserNotFoundException {
		User user1 = getUserById(user.getUserId());
		user1.setFirstName(user.getFirstName());
		user1.setLastName(user.getLastName());
		user1.setDob(user.getDob());
		user1.setEmail(user.getEmail());
		user1.setPhoneNumber(user.getPhoneNumber());
		
		userRepository.save(user1);
		return "User Information Updated";
	}

	@Override
	public String deleteUser(String userId) {
		userRepository.deleteById(userId);
		return "User Deleted";
	}

	@Override
	public User getUserById(String UserId) throws UserNotFoundException{
		return userRepository.findById(UserId).orElseThrow(()->new UserNotFoundException("User not found"));
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
