package com.codegym.be.controller;

import com.codegym.be.dto.FoodDto;
import com.codegym.be.dto.IFoodDto;
import com.codegym.be.model.Food;
import com.codegym.be.service.IFoodService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private IFoodService foodService;

    @GetMapping(value = "/list")
    public ResponseEntity<Page<IFoodDto>> getAllFood(@RequestParam(value = "name", defaultValue = "") String name,
                                                     Pageable pageable) {
        Page<IFoodDto> foodDto = foodService.findAllFood(name, pageable);
        if (foodDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(foodDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodDto> getFood(@PathVariable int id) {
        Optional<Food> food = foodService.findFoodById(id);
        if (!food.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        FoodDto foodDto = new FoodDto();
        BeanUtils.copyProperties(food.get(), foodDto);
        return new ResponseEntity<>(foodDto, HttpStatus.OK);
    }
}
