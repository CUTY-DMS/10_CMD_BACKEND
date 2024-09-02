package com.gdsc.cmd.domain.desired_meal.service;

import com.gdsc.cmd.domain.desired_meal.domain.DesiredMeal;
import com.gdsc.cmd.domain.desired_meal.domain.repository.DesiredMealRepository;
import com.gdsc.cmd.domain.desired_meal.dto.DesiredMealSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DesiredMealSave {
    private final DesiredMealRepository desiredMealRepository;

    public void save(DesiredMealSaveRequest saveRequest){
       DesiredMeal desiredMeal = DesiredMeal
               .builder()
               .content(saveRequest.getContent())
               .build();

       desiredMealRepository.save(desiredMeal);

    }
}
