package com.em;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig {

	@Bean
    public InMemoryUserDetailsManager userDetailsManager() {

		UserDetails main = User.builder()
	            .username("daniel080203")
	            .password(passwordEncoder().encode("test123"))
	            .roles("Employee", "Admin", "HR")
	            .build();

        return new InMemoryUserDetailsManager(main);
    }

	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	 
	 @Bean
	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	     http.cors(Customizer.withDefaults())  // Enable CORS
	         .authorizeHttpRequests(configurer ->
	             configurer
	                 .requestMatchers(HttpMethod.GET, "/employees/**").hasRole("Employee")
	                 .requestMatchers(HttpMethod.POST, "/employees").hasRole("Admin")
	                 .requestMatchers(HttpMethod.GET, "/hr/employees/**").hasRole("HR")
	                 .requestMatchers(HttpMethod.POST, "/hr/employees").hasRole("Admin")
	                 .requestMatchers(HttpMethod.GET, "/vacation-requests/**").hasRole("HR")
	                 .requestMatchers(HttpMethod.POST, "/vacation-requests/create").hasRole("Employee")
	                 .requestMatchers(HttpMethod.PUT, "/vacation-requests/**").hasRole("HR")
	                 .requestMatchers(HttpMethod.GET, "/messages").hasRole("Employee")
	                 .requestMatchers(HttpMethod.PUT, "/messages/dismiss/**").hasRole("Employee")
	         )
	         .httpBasic(Customizer.withDefaults())  // Use HTTP Basic authentication
	         .csrf(csrf -> csrf.disable());  // Disable CSRF

	     return http.build();
	 }

	 
	 @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**")
	                        .allowedOrigins("http://localhost:4200")
	                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
	                        .allowedHeaders("Authorization", "Content-Type")
	                        .exposedHeaders("Authorization")
	                        .allowCredentials(true);
	            }
	        };
	    }
}
