package com.gdsc.cmd.domain.desired_meal.domain.repository;

import com.gdsc.cmd.domain.desired_meal.domain.DesiredMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesiredMealRepository extends JpaRepository<DesiredMeal, Long> {
}
