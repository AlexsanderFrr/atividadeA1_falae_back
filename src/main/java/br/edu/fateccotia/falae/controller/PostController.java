package br.edu.fateccotia.falae.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fateccotia.falae.model.Post;
import br.edu.fateccotia.falae.service.PostsService;
import br.edu.fateccotia.falae.service.UsersService;


@RestController
@RequestMapping("/posts")
public class PostController {
	@Autowired
	private PostsService postsService;
	private UsersService usersService;
 	
	@PostMapping
	public ResponseEntity<Post> create(@RequestBody Map<String,String> post){
		Post created = new Post();
		created.setUser(usersService.findById(Integer.parseInt(post.get("user_id"))).get());
	}
	
	
	

}
