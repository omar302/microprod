package ot.microservice.microuserproduct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import ot.microservice.microuserproduct.data.User;

@Service
public class UserService {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackUser")
	public User getUser(Integer userId) {
		User user = restTemplate.getForObject("http://micro-user/users/" + userId, User.class);
		return user;
	}
	
	public User getFallbackUser(Integer userId) {
		return new User(userId, "not found", "not found", "not found");
	}
	
}
