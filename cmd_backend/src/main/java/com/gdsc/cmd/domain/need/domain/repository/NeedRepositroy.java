package com.gdsc.cmd.domain.need.domain.repository;


import com.gdsc.cmd.domain.need.domain.Need;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NeedRepositroy extends JpaRepository<Need,Long> {

}
