package com.task.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.task.repository.AppUserRepository;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ActiveUserContext {

    private final AppUserRepository userRepository;

    public String getLoggedInUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String loggedInUserName = userRepository.findByUsername(userDetails.getUsername()).getUsername();
        return loggedInUserName;
    }
}
