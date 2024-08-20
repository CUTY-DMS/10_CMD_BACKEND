package com.gdsc.cmd.domain.notification.service;

import com.gdsc.cmd.domain.notification.domain.Notification;
import com.gdsc.cmd.domain.notification.domain.repository.NotificationRepositroy;
import com.gdsc.cmd.domain.notification.dto.NotificationUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class NotificationUpdateService {
    private final NotificationRepositroy notificationRepositroy;
    private final NotificationFindById notificationFindById;

    @Transactional
    public void updateNotification(NotificationUpdateRequestDto updateDto, Long notificationId ){
        Notification notification = notificationFindById.findByNotificationId(notificationId);

        notification = Notification.builder()
                .title(updateDto.getTitle())
                .content(updateDto.getContent()).build();
                notificationRepositroy.save(notification);
    }
}
