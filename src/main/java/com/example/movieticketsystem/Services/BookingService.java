package com.example.movieticketsystem.Services;
import com.example.movieticketsystem.Entites.Meal;
import com.example.movieticketsystem.Entites.Movie;
import com.example.movieticketsystem.Entites.Booking;
import com.example.movieticketsystem.Entites.User;
import com.example.movieticketsystem.Exceptions.ApiException;
import com.example.movieticketsystem.Repositeries.BookingRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepositry bookingRepositry;
   private final MovieService movieService;
   private final MealService mealService;


    public Booking getUserBooking(User user) {
        return bookingRepositry.findByUserid(user.getId());
    }



    public Integer addBooking(Booking booking,User user) {
        Movie movie =movieService.getmoviebyname(booking.getMoviename());
        Meal meal=mealService.choosemeal(booking.getMeal());
        booking.setUserid(user.getId());
        Integer increase= movie.getPrice()*30/100;
        Integer discount= movie.getPrice()*20/100;
        if(movie.getMoviename()==null) {
            throw new ApiException("Movie is not found");
        }

        if (movie.getSeats() == 0) {
            throw new ApiException("Seats unavailable");
        }
        if (booking.getTickettype().equals("VIP")) {

            booking.setTotalprice(movie.getPrice()+increase+(meal.getMealprice()-discount));


        } if (booking.getTickettype().equals("VIP")&&booking.getMeal().equals("none")) {
            booking.setTotalprice(movie.getPrice()+increase);


        }

        if (booking.getTickettype().equals("Regular")) {

            booking.setTotalprice(movie.getPrice()+meal.getMealprice());


        }if (booking.getTickettype().equals("Regular")&& booking.getMeal().equals("none")) {

            booking.setTotalprice(movie.getPrice());

        }
        movie.setSeats(movie.getSeats()- booking.getNumofseats());
        bookingRepositry.save(booking);
        return booking.getTotalprice();
    }

    public Booking updateMovie(Booking booking, Integer id) {
        Booking oldtickets= bookingRepositry.getById(id);
       oldtickets.setTickettype(booking.getTickettype());
       oldtickets.setMoviename(booking.getMoviename());
       oldtickets.setMeal(booking.getMeal());
       oldtickets.setTotalprice(booking.getTotalprice());
        return bookingRepositry.save(booking);
    }


    public void deleteMovie(Integer id) {
      bookingRepositry.delete(bookingRepositry.getById(id));
    }

    public Integer upgradeticket(User user){
        Booking booking=bookingRepositry.findByUserid(user.getId());
       Movie movie =movieService.getmoviebyname(booking.getMoviename());
         Integer increase= movie.getPrice()*30/100;
         if(booking.getTickettype().equals("Regular")){
            booking.setTickettype("VIP");
            booking.setTotalprice(booking.getTotalprice()+increase);
            return booking.getTotalprice();
        }
        throw new ApiException("Cannot upgrade ticket because the ticket already upgrade it or not found");
}

public Integer AddaMeal(User user){
    Booking booking=bookingRepositry.findByUserid(user.getId());
    Movie movie =movieService.getmoviebyname(booking.getMoviename());
    Meal meal=mealService.choosemeal(booking.getMeal());
    Integer discount= movie.getPrice()*20/100;
    if(booking.getTickettype().equals("VIP")){
        booking.setTotalprice(booking.getTotalprice()+( meal.getMealprice()-discount));
       return booking.getTotalprice();
    }
    if(booking.getTickettype().equals("Regular")){
        booking.setTotalprice(booking.getTotalprice()+ meal.getMealprice());
        return booking.getTotalprice();
    }
        throw new ApiException("Invalid order");
}


}
