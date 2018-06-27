package itus._2014.king.springsecuirityexample.service;

import itus._2014.king.springsecuirityexample.model.CustomUserDetails;
import itus._2014.king.springsecuirityexample.model.User;
import itus._2014.king.springsecuirityexample.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUsers = usersRepository.findByName(username);

        optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        return optionalUsers
                .map(CustomUserDetails::new).get();
    }
}
