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
	public String updateUser(User user) {

		return null;
	}

	@Override
	public String deleteUser(String userId) {
		userRepository.deleteById(userId);
		return "User Deleted";
	}

	@Override
	public Optional<User> getUserById(String UserId) {
		return userRepository.findById(UserId);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
