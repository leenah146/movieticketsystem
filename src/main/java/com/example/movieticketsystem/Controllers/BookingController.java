package com.example.movieticketsystem.Controllers;

import com.example.movieticketsystem.Entites.Movie;
import com.example.movieticketsystem.Entites.Booking;
import com.example.movieticketsystem.Entites.User;
import com.example.movieticketsystem.Services.BookingService;
import com.example.movieticketsystem.Services.MovieService;
import com.example.movieticketsystem.dto.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/book")
public class BookingController {
    private final BookingService bookingService;



    @GetMapping
    public ResponseEntity GetuserBooking(@AuthenticationPrincipal User user){
        return  ResponseEntity.status(201).body(bookingService.getUserBooking(user));
    }

    @PostMapping
    public ResponseEntity bookmovie(@RequestBody Booking booking,@AuthenticationPrincipal User user){

        bookingService.addBooking(booking, user);
        return  ResponseEntity.status(201).body(new ApiResponse("movie hase been booked!",201));
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity UpdateTickets(@RequestBody @Valid Booking booking, @PathVariable Integer id,@AuthenticationPrincipal User user){
        bookingService.updateMovie(booking,id);
        return  ResponseEntity.status(201).body(new ApiResponse("Ticket updated!",201));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteticket(@PathVariable Integer id ,@AuthenticationPrincipal User user){
        bookingService.deleteMovie(id);
        return  ResponseEntity.status(201).body(new ApiResponse("Ticket cancelled!",201));
    }
    @PostMapping("/upgrade")
    public ResponseEntity UpgradeTicket(@AuthenticationPrincipal User user){
        bookingService.upgradeticket(user);
        return  ResponseEntity.status(201).body(new ApiResponse("Ticket upgrade it!",201));
    }

    @PostMapping("/addmeal")
    public ResponseEntity addmeal(@AuthenticationPrincipal User user){
        bookingService.AddaMeal(user);
        return  ResponseEntity.status(201).body(new ApiResponse("Meal been added it!",201));
    }


}
