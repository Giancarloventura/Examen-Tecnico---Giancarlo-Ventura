package com.spring.fullstack.test.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.fullstack.test.entity.User;
import com.spring.fullstack.test.service.IUserService;
import com.spring.fullstack.test.util.Response;
import com.spring.fullstack.test.util.ResponseMessages;
import com.spring.fullstack.test.util.StatusSpring;

@RestController
@RequestMapping
public class UserController {
	@Autowired IUserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<Response> createUser(@RequestBody User user){
		try {
			String message = userService.create(user);
			return ResponseEntity.ok().body(new Response(StatusSpring.OK, message));
		} catch (Exception e) {
			return ResponseEntity.ok().body(new Response(StatusSpring.ERROR, e.getMessage()));
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Response> udpateUser(@RequestBody User user){
		try {
			String message = userService.update(user);
			return ResponseEntity.ok().body(new Response(StatusSpring.OK, message));
		} catch (Exception e) {
			return ResponseEntity.ok().body(new Response(StatusSpring.ERROR, e.getMessage()));
		}
	}
	
	@GetMapping("/read")
	public ResponseEntity<Response> readUsers(){
		try {
			Response response = new Response(StatusSpring.OK,ResponseMessages.ALL_USERS_FOUND, userService.read());
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			return ResponseEntity.ok().body(new Response(StatusSpring.ERROR, e.getMessage()));
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> deleteUsers(@PathVariable Long id){
		try {
			String message = userService.delete(id);
			return ResponseEntity.ok().body(new Response(StatusSpring.OK, message));
		} catch (Exception e) {
			return ResponseEntity.ok().body(new Response(StatusSpring.ERROR, e.getMessage()));
		}
	}
}
