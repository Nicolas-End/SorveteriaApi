package com.sorverteria.Nicolas_End.SorverteriaApi.domain.authorization;

import com.sorverteria.Nicolas_End.SorverteriaApi.domain.user.RegisterDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.domain.user.UserEntity;
import com.sorverteria.Nicolas_End.SorverteriaApi.domain.user.UserRepository;
import com.sorverteria.Nicolas_End.SorverteriaApi.share.enums.UserRole;

import org.springframework.http.ResponseEntity;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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


    public ResponseEntity register(RegisterDTO data ){
        if(this.user.findByEmail(data.email()) != null ) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UserEntity newUser = new UserEntity(data.email(),data.name(),encryptedPassword,UserRole.COSTUMER);

        this.user.save(newUser);
        return ResponseEntity.ok().build();
    }
}
