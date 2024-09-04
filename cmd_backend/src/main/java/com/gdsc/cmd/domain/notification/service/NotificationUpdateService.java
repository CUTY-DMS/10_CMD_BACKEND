package com.gdsc.cmd.domain.notification.service;

import com.gdsc.cmd.domain.notification.domain.Notification;
import com.gdsc.cmd.domain.notification.domain.repository.NotificationRepositroy;
import com.gdsc.cmd.domain.notification.dto.NotificationUpdateRequestDto;
import com.gdsc.cmd.domain.user.domain.User;
import com.gdsc.cmd.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationUpdateService {
    private final NotificationRepositroy notificationRepositroy;
    private final NotificationFindById notificationFindById;
    private final UserFacade userFacade;




    @Transactional
    public void updateNotification(NotificationUpdateRequestDto updateDto, Long notificationId ){
        Notification notification = notificationFindById.findByNotificationId(notificationId);

        Optional<User> currentUser = userFacade.getCurrentUser();

        notification = Notification.builder()
                .title(updateDto.getTitle())
                .content(updateDto.getContent())
                .writer(currentUser.map(User::getAccountId).map(Object::toString).orElse("Unknown"))
                .build();
                notificationRepositroy.save(notification);
    }
}
