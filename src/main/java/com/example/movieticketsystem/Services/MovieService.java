package com.example.movieticketsystem.Services;
import com.example.movieticketsystem.Entites.Day;
import com.example.movieticketsystem.Entites.User;
import com.example.movieticketsystem.Entites.Movie;
import com.example.movieticketsystem.Exceptions.ApiException;
import com.example.movieticketsystem.Repositeries.MovieRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepositry movieRepositry;
    public List<Movie> getMovierepositery() {
        return movieRepositry.findAll();
    }


    public void addMovies(Movie movie) {
        movieRepositry.save(movie);
    }

    public Movie updateMovie(Movie movie, Integer id) {
        Movie oldmovie =movieRepositry.getById(id);
        oldmovie.setMoviename(movie.getMoviename());
        oldmovie.setAge(movie.getAge());
        oldmovie.setSummary(movie.getSummary());
        oldmovie.setGenre(movie.getGenre());
        oldmovie.setDuration(movie.getDuration());
        oldmovie.setDay(movie.getDay());
        oldmovie.setLocations(movie.getLocations());
        oldmovie.setTime(movie.getTime());
        oldmovie.setSeats(movie.getSeats());
        return movieRepositry.save(movie);
    }

    public void deleteMovie(Integer id) {
        movieRepositry.delete(movieRepositry.getById(id));
    }
    public Movie getmoviebyname(String name){
        Movie movie=movieRepositry.findMovieByMoviename(name);
        if(movie==null){
            throw new ApiException("Movie dosen't exist");
        }
        return movie;
    }
    public Movie getmoviebyid(Integer id){
        Movie movie=movieRepositry.getById(id);
        if(movie==null){
            throw new ApiException("Movie dosen't exist");
        }
        return movie;
    }
    public List<Movie> getmovieslessthanequal( User user) {
        return  movieRepositry.findByAgeLessThanEqual(user.getAge());

    }
    public List<Movie> getmoviebyday(Day day){
        return movieRepositry.findAllByDay(day);
    }

    public List<Movie> getmoviebygenre(String genre){
       List<Movie> movie =movieRepositry.findAllByGenre(genre);
        if(movie==null){
            throw new ApiException("Movie dosen't exist");
        }
        return movie;
    }

}
