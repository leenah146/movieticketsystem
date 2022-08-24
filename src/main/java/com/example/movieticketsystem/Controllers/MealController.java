package com.example.movieticketsystem.Controllers;
import com.example.movieticketsystem.Entites.Meal;
import com.example.movieticketsystem.Services.MealService;
import com.example.movieticketsystem.dto.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/meal")
public class MealController {
    private final MealService mealService;

    @GetMapping
    public ResponseEntity<List<Meal>> GetMeals(){


            return ResponseEntity.status(201).body(mealService.getMealrepositery());

    }

    @PostMapping
    public ResponseEntity AddMeals(@RequestBody @Valid Meal meal){
       mealService.addMeals(meal);
        return  ResponseEntity.status(201).body(new ApiResponse("meal added!",201));
    }

    @PutMapping("/{id}")
    public ResponseEntity Updatemovie(@RequestBody @Valid Meal meal,@PathVariable Integer id){
        mealService.updateMeal(meal,id);
        return  ResponseEntity.status(201).body(new ApiResponse("meal updated!",201));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deletemeals(@PathVariable Integer id){
        mealService.deleteMeal(id);
        return  ResponseEntity.status(201).body(new ApiResponse("meal deleted!",201));
    }
}
