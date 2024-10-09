package com.mingo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

import static com.mingo.entity.Role.ADMIN;
import static com.mingo.entity.Permission.ADMIN_READ;
import static com.mingo.entity.Permission.ADMIN_UPDATE;
import static com.mingo.entity.Permission.ADMIN_DELETE;
import static com.mingo.entity.Permission.ADMIN_CREATE;

import static com.mingo.entity.Role.MANAGER;
import static com.mingo.entity.Permission.MANAGER_READ;
import static com.mingo.entity.Permission.MANAGER_UPDATE;
import static com.mingo.entity.Permission.MANAGER_DELETE;
import static com.mingo.entity.Permission.MANAGER_CREATE;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;

@Service
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
	
	private static final String[] WHITE_LIST_URL = {"/api/v1/auth/**",
            "/v2/department"
            };
	private final JwtAuthenticationFilter jwtAuthFilter;
	private final AuthenticationProvider authenticationProvider;
	
	


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		System.out.println("SecurityFilterChain is working");
		http
		.csrf(AbstractHttpConfigurer::disable)
		.authorizeHttpRequests().requestMatchers(WHITE_LIST_URL).permitAll().anyRequest().authenticated().and()
		
		
		
//		.cors().and()
//		.authorizeHttpRequests(req->
//		req
//		.requestMatchers(WHITE_LIST_URL)
//		.permitAll()
//		.requestMatchers("/api/v2/manager/**").hasAnyRole("ADMIN", "MANAGER")
//		.requestMatchers(GET, "/api/v2/manager/**").hasAnyRole(ADMIN.name(), MANAGER.name())
//        .requestMatchers(POST, "/api/v2/manager/**").hasAnyRole(ADMIN.name(), MANAGER.name())
//        .requestMatchers(PUT, "/api/v2/manager/**").hasAnyRole(ADMIN.name(), MANAGER.name())
//        .requestMatchers(DELETE, "/api/v2/manager/**").hasAnyRole(ADMIN.name(), MANAGER.name())
//        .anyRequest()
//        .authenticated()
//		)
		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.authenticationProvider(authenticationProvider)
		.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
		

		System.out.println(ADMIN.name());
		
		
		return http.build();
	}
	
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        System.out.println("CorsConfigurationSource is working");
        return source;
    }

}
