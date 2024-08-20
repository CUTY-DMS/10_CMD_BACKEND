package com.gdsc.cmd.domain.notification.service;

import com.gdsc.cmd.domain.notification.domain.Notification;
import com.gdsc.cmd.domain.notification.domain.repository.NotificationRepositroy;
import com.gdsc.cmd.domain.notification.dto.NotificationCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;


@Service
@RequiredArgsConstructor
public class NotificationCreateService {
    private final NotificationRepositroy notificationRepositroy;

    public void postNotification(NotificationCreateRequestDto postDto){
        Calendar calendar = Calendar.getInstance();




        Notification notification = Notification.builder()
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .writer(postDto.getAccount_id())
                .createdTime(LocalDate.now())
                        .build();
        notificationRepositroy.save(notification);
    }
}
