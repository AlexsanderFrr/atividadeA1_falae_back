package br.edu.fateccotia.falae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fateccotia.falae.model.Users;
import br.edu.fateccotia.falae.service.UsersService;

@RestController
@RequestMapping("/users")

public class UsersController {
    @Autowired
    private UsersService userService;

    @PostMapping
    public ResponseEntity<Users> create(@RequestBody Users user){
        Users created = userService.save(user);
        return ResponseEntity.ok(created);
    }
}