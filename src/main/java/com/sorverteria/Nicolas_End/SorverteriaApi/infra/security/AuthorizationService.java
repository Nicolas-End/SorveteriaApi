package com.sorverteria.Nicolas_End.SorverteriaApi.infra.security;


import com.sorverteria.Nicolas_End.SorverteriaApi.domains.user.UserRepository;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;


@Service
public class AuthorizationService implements UserDetailsService {

    private final UserRepository user;


    public AuthorizationService(UserRepository user){

        this.user = user;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // procuar o email usuario pelo repositorio
        return user.findByEmail(email);
    }



}
