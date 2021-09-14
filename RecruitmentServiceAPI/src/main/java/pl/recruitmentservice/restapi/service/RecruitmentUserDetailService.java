package pl.recruitmentservice.restapi.service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RecruitmentUserDetailService implements UserDetailsService {

    private List<UserDetails> users;

    public RecruitmentUserDetailService() {
        super();
        users = Arrays.asList(
                new User("admin", "admin", new ArrayList<>()),
                new User("user", "user", new ArrayList<>())
        );
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserDetails userDetails = users.stream()
                    .filter(u -> u.getUsername().equals(username))
                    .findAny()
                    .get();
            return userDetails;
        } catch(NoSuchElementException ex) {
            throw new UsernameNotFoundException(username);
        }
    }

}
