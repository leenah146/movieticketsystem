package com.example.movieticketsystem.Repositeries;
import com.example.movieticketsystem.Entites.Day;
import com.example.movieticketsystem.Entites.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovieRepositry extends JpaRepository<Movie,Integer> {
    Movie findMovieByMoviename(String name);
    List<Movie> findByAgeLessThanEqual(Integer age);

    List<Movie> findAllByDay(Day day);
    List<Movie> findAllByGenre(String genre);

}
