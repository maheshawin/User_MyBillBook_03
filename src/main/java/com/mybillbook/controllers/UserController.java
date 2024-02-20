package com.mybillbook.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybillbook.entities.User;
import com.mybillbook.services.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

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

	@PostMapping("/save")
	public String updateUser(@RequestBody User user) {
		log.info("inside updateUser");
		return userService.updateUser(user);
	}

	@GetMapping("/{id}")
	public User getUserByUserId(@PathVariable("id") String userId) {
		log.info("inside getUserByUserId" + userId);
		return userService.getUserById(userId).get();
	}

	@GetMapping("/findall")
	public List<User> findAll() {
		log.info("inside get all users list");
		return userService.getAllUsers();
	}

}
