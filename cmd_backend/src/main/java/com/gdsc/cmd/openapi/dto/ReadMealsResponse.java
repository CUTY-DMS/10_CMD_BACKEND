package com.gdsc.cmd.openapi.dto;


import com.gdsc.cmd.openapi.domain.Meal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ReadMealsResponse {
    private String type;
    private String date;
    private String meals;
    private String calorie;

    public ReadMealsResponse(Meal meal) {
        this.type = meal.getMMEAL_SC_NM();
        this.date = meal.getDate();
        this.meals = meal.getDDISH_NM();
        this.calorie = meal.getCAL_INFO();
    }


}
