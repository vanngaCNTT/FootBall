package com.example.football.Controllers;

import com.example.football.Domains.Food;
import com.example.football.Repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/food")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping()
    public Iterable<Food> getAllFood(){
        return foodRepository.findAll( new Sort(Sort.Direction.ASC, "idFood"));
    }

    @GetMapping("/{id}")
    public Optional<Food> getOneDrink(@PathVariable int id){
        return foodRepository.findById(id);
    }

    @GetMapping("/count")
    public Long getCountFood(){
        return foodRepository.countFood();
    }

    @PostMapping("/new")
    public void createFood(@RequestBody Food food){
        foodRepository.save(food);
    }

    @PutMapping("/update")
    public void updateFood(@RequestBody Food food){
        foodRepository.save(food);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Food> deleteFood(@PathVariable int id){
        foodRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
