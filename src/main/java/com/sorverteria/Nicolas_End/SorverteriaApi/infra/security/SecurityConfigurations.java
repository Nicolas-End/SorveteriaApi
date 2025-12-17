package com.sorverteria.Nicolas_End.SorverteriaApi.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration // Indica que esta classe contém configurações do Spring
@EnableWebSecurity // Ativa o módulo de segurança do Spring Security
public class SecurityConfigurations {

    @Autowired
    SecurityFilter securityFilter; // Filtro personalizado para validar JWT

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        return httpSecurity
                // Desabilita CSRF pois estamos usando API stateless com JWT
                .csrf(csrf -> csrf.disable())

                // Define que a sessão será SEM estado (não mantém sessão do usuário)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // Configura as permissões de cada endpoint:
                .authorizeHttpRequests(authorize -> authorize

                        // Login e registro são públicos
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/auth/register").permitAll()

                        // Somente ADMIN acessa /admin
                        .requestMatchers("/admin/").hasRole("ADMIN")

                        // ADMIN e EMPLOYEER acessam /employeer
                        .requestMatchers("/employeer/").hasAnyRole( "EMPLOYEER","ADMIN")

                        // ADMIN, EMPLOYEER e COSTUMER acessam /costumer
                        .requestMatchers("/costumer/").hasAnyRole("ADMIN", "EMPLOYEER", "COSTUMER")

                        .requestMatchers("/user/").hasAnyRole("ADMIN","EMPLOYEER","COSTUMER")

                        .requestMatchers(HttpMethod.GET, "/order/",
                                "/sweet/",
                                "/fruit/",
                                "/accompaniment/").hasAnyRole("ADMIN","EMPLOYEER","COSTUMER")

                        .requestMatchers("/order/",
                                "/sweet/",
                                "/fruit/",
                                "/accompaniment/").hasAnyRole("ADMIN","EMPLOYEER")

                        // Qualquer outra requisição precisa de autenticação
                        .anyRequest().authenticated()
                )

                // Adiciona o filtro de JWT antes do filtro padrão de login
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)

                // Constrói o objeto SecurityFilterChain
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration){
        // Recupera o AuthenticationManager configurado internamente pelo Spring
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        // Fornece um encoder BCrypt para criptografar senhas
        return new BCryptPasswordEncoder();
    }
}
