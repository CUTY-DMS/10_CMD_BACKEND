package com.gdsc.cmd.domain.desired_meal.service;

import com.gdsc.cmd.domain.desired_meal.domain.repository.DesiredMealRepository;
import com.gdsc.cmd.domain.desired_meal.dto.DesiredMealFindAllResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindAllDesirdMealService {
    private final DesiredMealRepository desiredMealRepository;

    public List<DesiredMealFindAllResponse> findAllDesirdMeal() {
        return desiredMealRepository.findAll() //CRUD레포는 findAll() 메서드가 리스트로 반환 안됨
                .stream()
                .map(DesiredMealFindAllResponse::new)
                .collect(Collectors.toList());
    }
}
