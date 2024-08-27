package com.gdsc.cmd.domain.user.domain.repository;

import com.gdsc.cmd.domain.user.domain.User;
import com.gdsc.cmd.domain.user.domain.type.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByAccountId(String accountId);

    // 특정 역할에 해당되는 유저를 찾기 위해 사용하는 메소드
    List<User> findAllByRole(Role role);


}
