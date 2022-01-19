package ot.microservice.microuser.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ot.microservice.microuser.entity.User;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping()
	public List<User> getUsers() {
		
		List<User> users = getUserData();
		
		return users;		
	}
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") Integer userId) {
		
		Optional<User> opuser = getUserData().stream()
				.filter(u -> u.getId().equals(userId))
				.findFirst();
		
		if (opuser.isPresent()) {
			return opuser.get();
		}
		return null;		
	}
	
	private List<User> getUserData() {
		
		List<User> users = Arrays.asList(
				new User(1, "tsmith", "Tom", "Smith"),
				new User(2, "rtracey", "Rick", "Tracey"),
				new User(3, "hjones", "Harry", "Jones"));
		
		return users;
	}

}
