package com.example.movieticketsystem.Repositeries;
import com.example.movieticketsystem.Entites.Meal;
import com.example.movieticketsystem.Entites.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepositry extends JpaRepository<Meal,Integer> {
    Meal findMealByMeal(String name);
}
