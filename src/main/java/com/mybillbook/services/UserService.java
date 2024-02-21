package com.mybillbook.services;

import java.util.List;
import java.util.Optional;

import com.mybillbook.entities.User;
import com.mybillbook.exceptions.UserNotFoundException;

public interface UserService {

	String createUser(User user);

	String updateUser(User user)throws UserNotFoundException;

	String deleteUser(String userId);

	User getUserById(String UserId)throws UserNotFoundException;

	List<User> getAllUsers();

}
