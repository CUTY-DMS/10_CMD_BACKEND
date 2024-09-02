package com.gdsc.cmd.openapi.domain.repository;

import com.gdsc.cmd.openapi.domain.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal,Long> {

    //날짜로 급식 찾기
   List<Meal> findAllByDate(String date);

}
