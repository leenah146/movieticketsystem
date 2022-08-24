package com.example.movieticketsystem.Controllers;
import com.example.movieticketsystem.Entites.User;
import com.example.movieticketsystem.Services.UserService;
import com.example.movieticketsystem.dto.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/movie")
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public ResponseEntity GetUsers(@AuthenticationPrincipal User user){;
        return  ResponseEntity.status(201).body(userService.GetUser(user));
    }
    @GetMapping("/userad")
    public ResponseEntity GetUsersAdmin(){;
        return  ResponseEntity.status(201).body(userService.GetUserAdmin());
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid User user){
        userService.register(user);
        return  ResponseEntity.status(201).body(new ApiResponse("User added!",201));
    }
    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(200).body(new ApiResponse("Welcome back !",200));
    }

    @PutMapping("/user/{id}")
    public ResponseEntity UpdateUser(@RequestBody @Valid  User user, @PathVariable Integer id){
        userService.updateCustomer(user, id);
        return  ResponseEntity.status(201).body(new ApiResponse("User updated!",201));
    }



    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteCustomer(@PathVariable  Integer id,@AuthenticationPrincipal User user){
        userService.deleteuser(id);
        return  ResponseEntity.status(201).body(new ApiResponse("User deleted!",201));
    }
}
