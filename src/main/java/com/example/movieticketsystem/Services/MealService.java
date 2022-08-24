package com.example.movieticketsystem.Services;
import com.example.movieticketsystem.Entites.Meal;
import com.example.movieticketsystem.Exceptions.ApiException;
import com.example.movieticketsystem.Repositeries.MealRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MealService {
    private final MealRepositry mealRepositry;
    public List<Meal> getMealrepositery() {
        return mealRepositry.findAll();
    }


    public void addMeals(Meal meal) {
        mealRepositry.save(meal);
    }

    public Meal updateMeal(Meal meal, Integer id) {
       Meal oldmeal=mealRepositry.getById(id);
      oldmeal.setMeal(meal.getMeal());
      oldmeal.setMealprice(meal.getMealprice());
        return mealRepositry.save(meal);
    }

    public void deleteMeal(Integer id) {
        mealRepositry.delete(mealRepositry.getById(id));
    }
    public Meal choosemeal(String name){
        Meal meal=mealRepositry.findMealByMeal(name);
        if(meal==null){
            throw new ApiException("meal dosen't exist");
        }
        return meal;
    }

}
