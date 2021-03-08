package com.cts.esa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.esa.model.User;
import com.cts.esa.repo.UserRepository;

@RestController
public class UserController {

	@GetMapping("/user/auth")
	public ResponseEntity<User> authenticateUser(@RequestParam String id, @RequestParam String password) {
		System.out.println("User Id :: " + id);
		User user = UserRepository.matchPassword(id, password);
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}

	}

}
