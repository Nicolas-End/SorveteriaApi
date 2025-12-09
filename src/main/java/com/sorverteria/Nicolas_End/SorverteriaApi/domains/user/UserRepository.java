package com.sorverteria.Nicolas_End.SorverteriaApi.domains.user;


import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.user.RequestEmailDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.user.UserSummaryDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;


public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserDetails findByEmail(String email);

    RequestEmailDTO findByEmailAndRole(String email, UserRole role);

    ArrayList<UserSummaryDTO> findByRole(UserRole role);//  pegar os usuarios cadastrado pelo cargo
    
}