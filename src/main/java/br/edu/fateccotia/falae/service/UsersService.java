package br.edu.fateccotia.falae.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fateccotia.falae.model.User;
import br.edu.fateccotia.falae.repository.UsersRepository;

@Service
public class UsersService {
	private final UsersRepository userRepository;
	
	public UsersService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	public User save(User user) {
		return this.userRepository.save(user);
	}
	
	public void delete(Integer id) {
		this.userRepository.deleteById(id);
	}
public Optional<User> findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
	
	public Optional<User> findById(Integer id) {
        return this.userRepository.findById(id);
    }
	
	
}
