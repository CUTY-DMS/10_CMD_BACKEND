package com.gdsc.cmd.domain.desired_meal.controller;


import com.gdsc.cmd.domain.desired_meal.dto.DesiredMealFindAllResponse;
import com.gdsc.cmd.domain.desired_meal.dto.DesiredMealSaveRequest;
import com.gdsc.cmd.domain.desired_meal.service.DesiredMealSave;
import com.gdsc.cmd.domain.desired_meal.service.FindAllDesirdMealService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/DesiredMeal")
public class DesiredMealController {

    private final FindAllDesirdMealService findAllDesirdMealService;
    private final DesiredMealSave desiredMealSave;

    @PostMapping
    public void saveDesiredMeal(@RequestBody DesiredMealSaveRequest saveRequest) {
       desiredMealSave.save(saveRequest);
    }

    @GetMapping
    public List<DesiredMealFindAllResponse> findAllDesiredMeals() {
        return findAllDesirdMealService.findAllDesirdMeal();
    }

}
