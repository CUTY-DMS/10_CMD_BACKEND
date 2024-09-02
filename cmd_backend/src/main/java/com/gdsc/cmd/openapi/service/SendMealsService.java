package com.gdsc.cmd.openapi.service;

import com.gdsc.cmd.openapi.domain.Meal;
import com.gdsc.cmd.openapi.domain.repository.MealRepository;
import com.gdsc.cmd.openapi.dto.ReadMealsResponse;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SendMealsService {
    private final MealRepository mealRepository;

    public List<ReadMealsResponse> sendMeals(String date) {
          return mealRepository.findAllByDate(date)
                  .stream()
                  .map(ReadMealsResponse::new)
                  .collect(Collectors.toList());
    }
}
