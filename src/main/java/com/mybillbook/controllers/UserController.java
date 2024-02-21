package com.mybillbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybillbook.entities.User;
import com.mybillbook.exceptions.UserNotFoundException;
import com.mybillbook.services.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
@Tag(name ="User Management Service", description = "User Info")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/save")
	public String saveUser(@RequestBody User user) {
		log.info("inside saveUser");
		return userService.createUser(user);
	}

	@PostMapping("/delete")
	public String deleteUser(@RequestBody String userId) {
		log.info("inside deleteUser");
		return userService.deleteUser(userId);
	}

	@PostMapping("/update")
	public String updateUser(@RequestBody User user) throws UserNotFoundException{
		log.info("inside updateUser");
		return userService.updateUser(user);
	}

	@GetMapping("/{id}")
	public User getUserByUserId(@PathVariable("id") String userId) throws UserNotFoundException {
		log.info("inside getUserByUserId" + userId);
		return userService.getUserById(userId);
	}

	@GetMapping("/findall")
	public List<User> findAll() {
		log.info("inside get all users list");
		return userService.getAllUsers();
	}

}
