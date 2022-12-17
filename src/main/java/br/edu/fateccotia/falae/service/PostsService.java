package br.edu.fateccotia.falae.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.fateccotia.falae.model.Post;
import br.edu.fateccotia.falae.model.User;
import br.edu.fateccotia.falae.repository.PostsRepository;

@Service
public class PostsService {
	private final PostsRepository postRepository;
	
	
	public PostsService(PostsRepository postRepository) {
		this.postRepository = postRepository;
	}


	public Post save(Post post) {
		return this.postRepository.save(post);
	}
	public void delete(Integer id) {
		this.postRepository.deleteById(id);
	}
	public Optional<Post> findById(Integer id) {
        return this.postRepository.findById(id);
    }
	public Optional<Post> findByUser(User user) {
		return postRepository.findByUser(user);
	}
	public List<Post> findAll(){
		return this.postRepository.findAll();	
		}
	
}
