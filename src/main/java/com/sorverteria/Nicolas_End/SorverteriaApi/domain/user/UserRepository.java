package com.sorverteria.Nicolas_End.SorverteriaApi.domain.user;

import com.sorverteria.Nicolas_End.SorverteriaApi.domain.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    UserDetails findByName (String name);
}