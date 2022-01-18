package ot.microservice.microuser.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ot.microservice.microuser.entity.User;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping()
	public List<User> getUsers() {
		
		List<User> users = Arrays.asList(
				new User(1, "tsmith", "Tom", "Smith"),
				new User(2, "rtracey", "Rick", "Tracey"),
				new User(3, "hjones", "Harry", "Jones"));
		
		return users;		
	}

}
