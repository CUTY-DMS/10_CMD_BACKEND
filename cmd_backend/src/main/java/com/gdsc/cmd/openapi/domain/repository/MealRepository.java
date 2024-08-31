package com.gdsc.cmd.openapi.domain.repository;

import com.gdsc.cmd.openapi.domain.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends CrudRepository<Meal,Long> {

    //날짜로 급식 찾기
    List<Meal> findByDate(String date);

}
