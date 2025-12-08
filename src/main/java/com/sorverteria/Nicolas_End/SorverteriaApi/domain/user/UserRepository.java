package com.sorverteria.Nicolas_End.SorverteriaApi.domain.user;


import com.sorverteria.Nicolas_End.SorverteriaApi.dto.UserSummaryDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;


public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserDetails findByEmail(String email);


    ArrayList<UserSummaryDTO> findByRole(UserRole role); //  pegar os usuarios cadastrado pelo cargo
}