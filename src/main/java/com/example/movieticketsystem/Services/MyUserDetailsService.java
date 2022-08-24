package com.example.movieticketsystem.Services;
import com.example.movieticketsystem.Entites.User;
import com.example.movieticketsystem.Repositeries.UserRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {


    private final UserRepositry userRepositry;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User myuser=userRepositry.findUserByUsername(username);

        if(myuser==null){
            throw new UsernameNotFoundException("Invalid username or password");
        }

        return myuser;
    }
}