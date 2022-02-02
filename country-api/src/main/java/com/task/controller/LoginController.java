package com.task.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.security.Login;
import com.task.security.TokenProvider;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "login")
@RequiredArgsConstructor
public class LoginController {

	private final AuthenticationManager authenticationManager;

	private final TokenProvider jwtProvider;

	private final UserDetailsService userDetailsService;

	@PostMapping
	public ResponseEntity<?> authenticationToken(@RequestBody Login login) throws AuthenticationException {

		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		final UserDetails userDetails = userDetailsService.loadUserByUsername(login.getUsername());

		final String accessToken = jwtProvider.generateToken(userDetails);

		final String refreshToken = jwtProvider.generateRefreshToken(userDetails);

		Map<String, Object> token = new HashMap<String, Object>();
		token.put("token", accessToken);
		token.put("refreshToken", refreshToken);
		token.put("username", userDetails.getUsername());
		return ResponseEntity.ok(token);
	}
}
