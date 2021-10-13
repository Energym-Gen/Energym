package com.generation.energym.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.generation.energym.model.UsuarioModel;
import com.generation.energym.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImplements implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<UsuarioModel> user = userRepository.findByEmail(email);
		user.orElseThrow(() -> new UsernameNotFoundException(email + " not found."));

		return user.map(UserDetailsImplements::new).get();
	}

}
