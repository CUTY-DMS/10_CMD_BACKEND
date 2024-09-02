package com.gdsc.cmd.domain.notification.domain.repository;


import com.gdsc.cmd.domain.notification.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepositroy extends JpaRepository<Notification,Long> {


}
