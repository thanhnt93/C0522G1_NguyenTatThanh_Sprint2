package com.codegym.be.service.impl;

import com.codegym.be.dto.IFoodDto;
import com.codegym.be.model.Food;
import com.codegym.be.repository.IFoodRepository;
import com.codegym.be.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoodService implements IFoodService {
    @Autowired
    protected IFoodRepository foodRepository;

    @Override
    public Page<IFoodDto> findAllFood(String nameSearch, Pageable pageable) {
        return foodRepository.findAllFood(nameSearch, pageable);
    }

    @Override
    public Optional<Food> findFoodById(int id) {
        return foodRepository.findFoodById(id);
    }
}
