package com.sorverteria.Nicolas_End.SorverteriaApi.domains.user;


import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.user.*;
import com.sorverteria.Nicolas_End.SorverteriaApi.infra.security.AuthenticatedUser;
import com.sorverteria.Nicolas_End.SorverteriaApi.infra.security.TokenService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.sorverteria.Nicolas_End.SorverteriaApi.enums.UserRole;
import java.util.ArrayList;
import java.util.UUID;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final AuthenticatedUser authUser;

    public UserService(UserRepository userRepository, AuthenticationManager authenticationManager, TokenService tokenService, AuthenticatedUser authUser){
        this.userRepository=userRepository;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.authUser = authUser;
    }


    public ResponseEntity register(RegisterDTO data, UserRole role){    // Registra um novo usuario de acordo com a role passada
        if(this.userRepository.findByEmail(data.email()) != null ) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UserEntity newUser = new UserEntity(data.email(),data.name(),encryptedPassword, role);

        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }



    public ResponseEntity login(AuthenticationDTO data){ // realiza o login do usuario e retorna um token valido por duas horas
        var usenamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usenamePassword);

        var token = tokenService.generateToken((UserEntity) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    public ArrayList<UserSummaryDTO> getUsersByRole(UserRole role){
        return userRepository.findByRole(role);// retorna os usuario cadastrado por meio do cargo
    }


    @Transactional // garante que todas ações serão realizadas em caso de erro é desfeito
    public ResponseEntity dropEmployeer(String email) {

        // verifica se o usuario é employeer mesmo

            if (this.userRepository.findByEmailAndRole(email, UserRole.EMPLOYEER) == null){
            return ResponseEntity.badRequest().build();
        }
        this.userRepository.deleteById(email);
        return ResponseEntity.ok("Funcionario Apagado com sucesso");

    }

    public ResponseEntity updateUserCpf(RequestNewCpfDTO data){
        authUser.get().setCpf(data.cpf());

        userRepository.save(authUser.get());

        return ResponseEntity.ok("Novo cpf cadastrado com sucesso");

    }

    public UserEntity findUser(String email){

        return userRepository.findById(email).orElse(null);

    }

}
