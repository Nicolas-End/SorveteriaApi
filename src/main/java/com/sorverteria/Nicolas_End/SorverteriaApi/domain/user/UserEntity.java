package com.sorverteria.Nicolas_End.SorverteriaApi.domain.user ;

import com.sorverteria.Nicolas_End.SorverteriaApi.share.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name="TB_USERS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity implements UserDetails {

    @Id
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true , unique = true)
    private String cpf;

    @Column(nullable = false,unique = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,unique = false)
    private UserRole role;

    public UserEntity (String email, String name, String password, UserRole role){
        this.email = email;
        this.name=name;
        this.cpf=null;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if (this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_EMPLOYEER"), new SimpleGrantedAuthority("ROLE_COSTUMER"));
        else if (this.role == UserRole.EMPLOYEER) return List.of(new SimpleGrantedAuthority("ROLE_EMPLOYEER"), new SimpleGrantedAuthority("ROLE_COSTUMER"));
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
