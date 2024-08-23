package com.gdsc.cmd.domain.notification.service;

import com.gdsc.cmd.domain.notification.domain.Notification;
import com.gdsc.cmd.domain.notification.domain.repository.NotificationRepositroy;
import com.gdsc.cmd.domain.notification.dto.NotificationCreateRequestDto;
import com.gdsc.cmd.domain.user.domain.User;
import com.gdsc.cmd.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class NotificationCreateService {
    private final NotificationRepositroy notificationRepositroy;
    private final UserFacade userFacade;

    public void postNotification(NotificationCreateRequestDto postDto){
        Calendar calendar = Calendar.getInstance();

        Optional<User> currentUser = userFacade.getCurrentUser();

        Notification notification = Notification.builder()
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .writer(currentUser.toString())
                .createdTime(LocalDate.now())
                        .build();
        notificationRepositroy.save(notification);
    }
}
