package com.codegym.be.service;

import com.codegym.be.model.Food;
import com.codegym.be.dto.IFoodDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IFoodService {
    Page<IFoodDto> findAllFood(String nameSearch, Pageable pageable);

    Optional<Food> findFoodById(int id);
}
