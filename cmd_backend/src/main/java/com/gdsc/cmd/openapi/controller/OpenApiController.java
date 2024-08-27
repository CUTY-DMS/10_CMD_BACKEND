package com.gdsc.cmd.openapi.controller;

import com.gdsc.cmd.openapi.domain.type.StatusEnum;
import com.gdsc.cmd.openapi.exception.Message;
import com.gdsc.cmd.openapi.service.SchoolMealsOpenApiService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openapi")
public class OpenApiController {

    private final SchoolMealsOpenApiService mealsOpenApiService;

    @Autowired
    public OpenApiController(SchoolMealsOpenApiService mealsOpenApiService) {
        this.mealsOpenApiService = mealsOpenApiService;
    }

    @PostMapping("fetch-meals")
    private void OpenApiSave() {
        try {
            System.out.println("fsfsd111111111111111111111111");

            mealsOpenApiService.fetchMeals();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}