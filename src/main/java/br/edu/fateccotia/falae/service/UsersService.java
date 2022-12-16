package br.edu.fateccotia.falae.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.fateccotia.falae.model.User;
import br.edu.fateccotia.falae.repository.UsersRepository;

@Service
public class UsersService {
	private final UsersRepository userRepository;
	private final PasswordEncoder encoder;
	
	
	public UsersService(UsersRepository userRepository, PasswordEncoder encoder) {
		this.encoder = encoder;
        this.userRepository = userRepository;
    }
	
	public User save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
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
