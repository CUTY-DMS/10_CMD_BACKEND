package com.gdsc.cmd.domain.desired_meal.dto;

import com.gdsc.cmd.domain.desired_meal.domain.DesiredMeal;
import lombok.Getter;

@Getter
public class DesiredMealFindAllResponse {
    private String content;

    public DesiredMealFindAllResponse(DesiredMeal desiredMeal) {
        this.content = desiredMeal.getContent();
    }
}
