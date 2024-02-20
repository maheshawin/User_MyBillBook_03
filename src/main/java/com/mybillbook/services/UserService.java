package com.mybillbook.services;

import java.util.List;
import java.util.Optional;

import com.mybillbook.entities.User;

public interface UserService {

	String createUser(User user);

	String updateUser(User user);

	String deleteUser(String userId);

	Optional<User> getUserById(String UserId);

	List<User> getAllUsers();

}
