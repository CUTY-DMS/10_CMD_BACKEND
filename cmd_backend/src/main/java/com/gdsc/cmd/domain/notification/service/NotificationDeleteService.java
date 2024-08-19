package com.gdsc.cmd.domain.notification.service;

import com.gdsc.cmd.domain.notification.domain.repository.NotificationRepositroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationDeleteService {
    private final NotificationRepositroy notificationRepositroy;

    public void deleteNotification(Long NotificationId){

        notificationRepositroy.deleteById(NotificationId);
    }
}
