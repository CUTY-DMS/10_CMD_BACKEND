package com.gdsc.cmd.openapi.controller;

import com.gdsc.cmd.openapi.domain.Meal;
import com.gdsc.cmd.openapi.domain.type.StatusEnum;
import com.gdsc.cmd.openapi.dto.ReadMealsResponse;
import com.gdsc.cmd.openapi.exception.Message;
import com.gdsc.cmd.openapi.service.SchoolMealsOpenApiService;
import com.gdsc.cmd.openapi.service.SendMealsService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/openapi/meals")
@RequiredArgsConstructor
public class OpenApiController {
    private final SendMealsService sendMealsService;
    private final SchoolMealsOpenApiService mealsOpenApiService;



    @GetMapping("/{date}")
    public List<ReadMealsResponse> sendMeal(@PathVariable String date){

        return sendMealsService.sendMeals(date);
    }

    @PostMapping
    private void OpenApiSave() {
        try {
            mealsOpenApiService.fetchMeals();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}