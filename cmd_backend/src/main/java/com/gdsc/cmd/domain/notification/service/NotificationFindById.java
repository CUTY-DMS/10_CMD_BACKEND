package com.gdsc.cmd.domain.notification.service;

import com.gdsc.cmd.domain.notification.domain.Notification;
import com.gdsc.cmd.domain.notification.domain.repository.NotificationRepositroy;
import com.gdsc.cmd.domain.notification.domain.type.ExceptionCode;
import com.gdsc.cmd.domain.notification.exception.BusinessLogicException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationFindById {

    private final NotificationRepositroy notificationRepositroy;

    public Notification findByNotificationId(Long notificationId){
        return notificationRepositroy.findById(notificationId)
                .orElseThrow(()->new
                        BusinessLogicException(ExceptionCode.NEED_NOT_FOUND));
    }

}
