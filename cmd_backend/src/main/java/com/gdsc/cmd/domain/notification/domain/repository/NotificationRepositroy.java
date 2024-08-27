package com.gdsc.cmd.domain.notification.domain.repository;


import com.gdsc.cmd.domain.notification.domain.Notification;
import com.gdsc.cmd.domain.notification.dto.NotificationListResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepositroy extends JpaRepository<Notification,Long> {


}
