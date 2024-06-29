package Student.Student_micro.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class CustomSecurity {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers("Student/public").permitAll() // Allow access to static resources
//                .requestMatchers("/admin/**").hasRole("ADMIN") // Require ADMIN role for /admin/**
                .anyRequest().authenticated() // Require authentication for other requests
                .and()
                .formLogin(withDefaults()); // Enable form-based login

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails publicUser= User.withUsername("user")
                .password(passwordEncoder().encode("user"))
                .roles("normal")
                .build();

        UserDetails adminUser= User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("admin")
                .build();

        return new InMemoryUserDetailsManager(publicUser,adminUser);

    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }
}
