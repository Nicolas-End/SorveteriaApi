package com.sorverteria.Nicolas_End.SorverteriaApi.domain.user ;

import com.sorverteria.Nicolas_End.SorverteriaApi.share.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name="TB_USERS")
@Data
public class UserEntity implements UserDetails {

    @Id
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true , unique = true)
    private int cpf;

    @Column(nullable = false,unique = false)
    private String password;

    @Column(nullable = false,unique = false)
    private UserRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if (this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_EMPLOYEER"), new SimpleGrantedAuthority("ROLE_COSTUMER"));
        else if (this.role == UserRole.EMPLOYEE) return List.of(new SimpleGrantedAuthority("ROLE_EMPLOYEER"), new SimpleGrantedAuthority("ROLE_COSTUMER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_COSTUMER"));
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
