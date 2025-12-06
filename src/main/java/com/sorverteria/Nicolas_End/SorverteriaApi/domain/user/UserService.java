package com.sorverteria.Nicolas_End.SorverteriaApi.domain.user;

import com.sorverteria.Nicolas_End.SorverteriaApi.domain.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }


}
