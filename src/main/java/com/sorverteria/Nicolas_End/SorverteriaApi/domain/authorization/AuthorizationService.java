package com.sorverteria.Nicolas_End.SorverteriaApi.domain.authorization;

import com.sorverteria.Nicolas_End.SorverteriaApi.domain.user.RegisterDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.domain.user.UserEntity;
import com.sorverteria.Nicolas_End.SorverteriaApi.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    UserRepository user;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return user.findByEmail(email);
    }

    public ResponseEntity login(RegisterDTO data ){
        if(this.user.findByEmail(data.email()) != null ) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UserEntity newUser = new UserEntity(data.email(),data.name(),encryptedPassword,data.role());

        this.user.save(newUser);
        return ResponseEntity.ok().build();
    }
}
