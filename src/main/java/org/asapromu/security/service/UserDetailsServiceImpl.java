package org.asapromu.security.service;

import java.util.List;
import java.util.Set;

import org.asapromu.entities.Users;
import org.asapromu.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var usuario = getById(username);

		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		return User.withUsername(username).password(usuario.password()).roles(usuario.roles().toArray(new String[0]))
				.build();
	}

	public record Usuario(String username, String password, Set<String> roles) {
	};

	public Usuario getById(String username) {
		Users usr = userService.getByUser(username);
		Usuario user = new Usuario(usr.getUsername(), usr.getPassworduser(), Set.of("ADMIN"));
	    var usuarios = List.of(user);

	    return usuarios
      .stream()
      .filter(e -> e.username().equals(username))
      .findFirst()
      .orElse(null);
	    
	}
}
