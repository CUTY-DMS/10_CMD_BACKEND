package com.gdsc.cmd.domain.need.repository;


import com.gdsc.cmd.domain.need.entity.Need;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NeedRepositroy extends JpaRepository<Need,Long> {

}
