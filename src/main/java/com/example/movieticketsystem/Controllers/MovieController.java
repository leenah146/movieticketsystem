package com.example.movieticketsystem.Controllers;
import com.example.movieticketsystem.Entites.Day;
import com.example.movieticketsystem.Entites.Movie;
import com.example.movieticketsystem.Entites.User;
import com.example.movieticketsystem.Services.MovieService;
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
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/show")
    public ResponseEntity<List<Movie>> GetMovies(@AuthenticationPrincipal User user){
        if (user == null) {

            return ResponseEntity.status(201).body(movieService.getMovierepositery());
        }
        return ResponseEntity.status(201).body(movieService.getmovieslessthanequal(user));
    }

    @PostMapping("/mov")
    public ResponseEntity Addmovies(@RequestBody @Valid Movie movie){
        movieService.addMovies(movie);
        return  ResponseEntity.status(201).body(new ApiResponse("movie added!",201));
    }

    @PutMapping("/mov/{id}")
    public ResponseEntity Updatemovie(@RequestBody @Valid Movie movie,@PathVariable Integer id){
        movieService.updateMovie(movie, id);
        return  ResponseEntity.status(201).body(new ApiResponse("movie updated!",201));
    }
    @DeleteMapping("/mov/{id}")
    public ResponseEntity deletemovie(@PathVariable Integer id){
        movieService.deleteMovie(id);
        return  ResponseEntity.status(201).body(new ApiResponse("movie deleted!",201));
    }
    @GetMapping("/name")
    public ResponseEntity<Movie> GetMovieByName(@RequestParam String name){
       Movie movie=movieService.getmoviebyname(name);
        return  ResponseEntity.status(200).body(movie);
    }

    @GetMapping("/days")
    public ResponseEntity<List<Movie>> GetMovieByday(@RequestParam Day day){
        return  ResponseEntity.status(200).body(movieService.getmoviebyday(day));
    }
    @GetMapping("/genre")
    public ResponseEntity<List<Movie>> GetMovieBygenre(@RequestParam String genre){
        return  ResponseEntity.status(200).body(movieService.getmoviebygenre(genre));
    }
}
