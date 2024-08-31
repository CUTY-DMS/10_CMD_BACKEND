package com.gdsc.cmd.openapi.service;

import com.gdsc.cmd.openapi.domain.Meal;
import com.gdsc.cmd.openapi.domain.repository.MealRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SendMealsService {
    private final MealRepository mealRepository;

    public List<Meal> sendMeals(String date) {
        List<Meal> meals = mealRepository.findByDate(date);
        return meals;
    }
}
