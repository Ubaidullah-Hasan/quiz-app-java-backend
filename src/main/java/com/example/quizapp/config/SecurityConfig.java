// package com.example.quizapp.config;

// import com.example.quizapp.security.JwtAuthenticationEntryPoint;
// import com.example.quizapp.security.JwtAuthenticationFilter;
// import lombok.RequiredArgsConstructor;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @Configuration
// @EnableWebSecurity
// @RequiredArgsConstructor
// public class SecurityConfig {

//     private final JwtAuthenticationEntryPoint unauthorizedHandler;
//     private final JwtAuthenticationFilter jwtAuthenticationFilter;

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//                 // Disable CSRF protection (common for APIs)
//                 .csrf(csrf -> csrf.disable())

//                 // Configure exception handling
//                 .exceptionHandling(exception -> exception
//                         .authenticationEntryPoint(unauthorizedHandler))

//                 // Set session management to stateless (no sessions)
//                 .sessionManagement(session -> session
//                         .sessionCreationPolicy(SessionCreationPolicy.STATELESS))

//                 // Configure authorization rules
//                 .authorizeHttpRequests(auth -> auth
//                         // Public endpoints
//                         .requestMatchers("/", "/public/**", "/api/auth/**").permitAll()
//                         // All other endpoints require authentication
//                         .anyRequest().authenticated())

//                 // Add JWT filter before the default authentication filter
//                 .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

//         return http.build();
//     }

//     @Bean
//     public AuthenticationManager authenticationManager(
//             AuthenticationConfiguration authenticationConfiguration) throws Exception {
//         return authenticationConfiguration.getAuthenticationManager();
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }


package com.example.quizapp.config;

import com.example.quizapp.security.JwtAuthenticationEntryPoint;
import com.example.quizapp.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

        private final JwtAuthenticationEntryPoint unauthorizedHandler;
        private final JwtAuthenticationFilter jwtAuthenticationFilter;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                // Disable CSRF protection (common for APIs)
                                .csrf(csrf -> csrf.disable())

                                // Configure exception handling
                                .exceptionHandling(exception -> exception
                                                .authenticationEntryPoint(unauthorizedHandler))

                                // Set session management to stateless (no sessions)
                                .sessionManagement(session -> session
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                                // Configure authorization rules
                                .authorizeHttpRequests(auth -> auth
                                                // Public endpoints
                                                .requestMatchers("/", "/public/**", "/api/auth/**", "/**").permitAll()
                                                // All other endpoints require authentication
                                                .anyRequest().authenticated())

                                // Add JWT filter before the default authentication filter
                                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

                return http.build();
        }

        @Bean
        public AuthenticationManager authenticationManager(
                        AuthenticationConfiguration authenticationConfiguration) throws Exception {
                return authenticationConfiguration.getAuthenticationManager();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }
}
