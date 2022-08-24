package com.example.movieticketsystem.Services;
import com.example.movieticketsystem.Entites.User;
import com.example.movieticketsystem.Exceptions.ApiException;
import com.example.movieticketsystem.Repositeries.UserRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepositry userRepositry;


    public List<User> getCustomersrepositery() {
        return userRepositry.findAll();
    }

    public void register(User user) {
        String hashedPassword= new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepositry.save(user);
    }

    public User updateCustomer(User user, Integer id) {
        User oldcustomer = userRepositry.getById(id);
       oldcustomer.setUsername(user.getUsername());
       oldcustomer.setEmail(user.getEmail());
       oldcustomer.setPassword(user.getPassword());
       oldcustomer.setPhonenumber(user.getPhonenumber());
       oldcustomer.setAge(user.getAge());
       oldcustomer.setGender(user.getGender());
        return userRepositry.save(user);

    }

    public void deleteuser(Integer id) {
      userRepositry.delete(userRepositry.getById(id));
    }
    public User getuserbyid(Integer id){
        User user = userRepositry.findUserById(id);
        if(user ==null){
            throw new ApiException("wrond id");
        }
        return user;
    }
    public User getuserbyname(String name){
       User user=userRepositry.findUserByUsername(name);
        if(user==null){
            throw new ApiException("user dosen't exist");
        }
        return user;
    }
}
