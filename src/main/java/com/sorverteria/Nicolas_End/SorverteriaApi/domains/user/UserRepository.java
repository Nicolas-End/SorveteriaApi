package com.sorverteria.Nicolas_End.SorverteriaApi.domains.user;



import com.sorverteria.Nicolas_End.SorverteriaApi.dtos.user.UserSummaryDTO;
import com.sorverteria.Nicolas_End.SorverteriaApi.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserDetails findByEmail(String email);

    String findByEmailAndRole(String email, UserRole role);

    ArrayList<UserSummaryDTO> findByRole(UserRole role);//  pegar os usuarios cadastrado pelo cargo
    
}