package org.asapromu.services;

import org.asapromu.entities.Users;
import org.asapromu.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public Users getByUser(String usr) {
		return userRepository.findByUsername(usr).get();
	}
	
	public Users save(Users usr) {
		return userRepository.save(usr);
	}
	
	public Users getByToken(String token){
		String barrer = token.split(" ")[1];
		return userRepository.findByTokenuser(barrer).get();
	}

}
