package com.gdsc.cmd.openapi.domain.repository;

import com.gdsc.cmd.openapi.domain.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends CrudRepository<Meal,Long> {
}
