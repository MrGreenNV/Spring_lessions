package ru.averkiev.springlesson.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.averkiev.springlesson.services.PersonDetailsService;

@EnableWebSecurity
@Component
public class SecurityConfig {

//    private final PersonDetailsService personDetailsService;
//
//    @Autowired
//    public SecurityConfig(PersonDetailsService personDetailsService) {
//        this.personDetailsService = personDetailsService;
//    }


//
//    private final AuthProviderImpl authProvider;
//
//    @Autowired
//    public SecurityConfig(AuthProviderImpl authProvider) {
//        this.authProvider = authProvider;
//    }
//
//    // Настраивает аутентификацию
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(personDetailsService);
//    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
