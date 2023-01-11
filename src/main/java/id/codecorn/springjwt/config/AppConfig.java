package id.codecorn.springjwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import id.codecorn.springjwt.dao.UsersDao;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AppConfig {
    private final UsersDao usersDao;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> usersDao.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }
}
