package com.gdsc.cmd.domain.notification.service;

import com.gdsc.cmd.domain.notification.domain.Notification;
import com.gdsc.cmd.domain.notification.dto.NotificationFindResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NotificationReadService {
    private final NotificationFindById notificationFindById;

    public NotificationFindResponseDto readNotification(Long notificationId){
        Notification notification = notificationFindById.findByNotificationId(notificationId);
        return NotificationFindResponseDto.from(notification);
    }
}
