package com.gdsc.cmd.domain.notification.service;

import com.gdsc.cmd.domain.notification.domain.Notification;
import com.gdsc.cmd.domain.notification.dto.NotificationFindResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationReadService {
    private final NotificationFindById notificationFindById;

    public NotificationFindResponseDto readNotification(Long notificationId){
        Notification notification = notificationFindById.findByNotificationId(notificationId);
        return NotificationFindResponseDto.FindFromNotification(notification);
    }
}
