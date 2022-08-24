package com.example.movieticketsystem.Entites;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "username cannot be empty")
    private String username;
    @NotEmpty(message = "email cannot be empty")
    @Email
    @Column(unique = true)
    private String email;
    @NotEmpty(message = "password cannot be empty")
    private String password;
    @NotEmpty(message = "phone number cannot be empty")
    @Size(min=10, message = "phone number need to be at least 10 digits")
    private String phonenumber;
    private String role;
    @NotNull(message = "age cannot be empty")
    private Integer age;
    @Column(columnDefinition = "varchar(1) check (gender='F' or gender='M') ")
    private String gender;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.role));
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
