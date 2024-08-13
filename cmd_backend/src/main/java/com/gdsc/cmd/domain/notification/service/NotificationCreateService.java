package com.gdsc.cmd.domain.notification.service;

import com.gdsc.cmd.domain.notification.domain.Notification;
import com.gdsc.cmd.domain.notification.domain.repository.NotificationRepositroy;
import com.gdsc.cmd.domain.notification.dto.NotificationCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationCreateService {

    private final NotificationRepositroy notificationRepositroy;

    public void postNotification(NotificationCreateRequestDto postDto){
        Notification notification = new Notification();
        notification.setContent(postDto.getContent());
        notification.setTitle(postDto.getTitle());
        notificationRepositroy.save(notification);
    }
}
