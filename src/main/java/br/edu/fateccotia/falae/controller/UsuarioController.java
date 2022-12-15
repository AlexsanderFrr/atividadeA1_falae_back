package br.edu.fateccotia.falae.controller;

import java.util.Optional;

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

import br.edu.fateccotia.falae.model.User;
import br.edu.fateccotia.falae.service.UsersService;


@RestController
@RequestMapping("/users")

public class UsuarioController {
	@Autowired
	private UsersService usersService;
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user){
		User created = usersService.save(user);
		return ResponseEntity.ok(created);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> find(@PathVariable(name ="id") Integer id){
		Optional<User> user = this.usersService.findById(id);
		if(user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}else {
			return ResponseEntity.ok(user.get());
		}
	}
	
	
//	public ResponseEntity<Users> get(@PathVariable(name = "id") Integer id){
//		Users created = user.findById(id).get();
//		
//		if(userService.\findById(id).isPresent()) {
//			created = u
@PutMapping
	public ResponseEntity<User> recuperate(@RequestBody User user){
		User created = usersService.save(user);
		return ResponseEntity.ok(created);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> delete(@PathVariable("id") Integer id){
		
		if(usersService.findById(id).isPresent()) {
			usersService.delete(id);
		}
		return ResponseEntity.ok(null);
	}
	
}