package com.gdsc.cmd.domain.notification.service;


import com.gdsc.cmd.domain.notification.domain.Notification;
import com.gdsc.cmd.domain.notification.domain.type.ExceptionCode;
import com.gdsc.cmd.domain.notification.dto.NotificationPostRequestDto;
import com.gdsc.cmd.domain.notification.dto.NotificationFindRequestDto;
import com.gdsc.cmd.domain.notification.dto.NotificationUpdateDto;
import com.gdsc.cmd.domain.notification.domain.repository.NotificationRepositroy;
import com.gdsc.cmd.domain.notification.exception.BusinessLogicException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepositroy notificationRepositroy;



    public Long postneed(NotificationPostRequestDto postDto){
        Notification notification = new Notification();
        notification.setContent(postDto.getContent());
        notification.setTitle(postDto.getTitle());
        return notificationRepositroy.save(notification).getNeedId();
    }

    
    public NotificationFindRequestDto readNotification(Long notificationId){
        Notification notification = findByNotificationId(notificationId);
        return NotificationFindRequestDto.FindFromNeed(notification);
    }


    @Transactional
    public Long updateNeed(NotificationUpdateDto updateDto, Long notificationId ){
        Notification notification = findByNotificationId(notificationId);
        notification.setTitle(updateDto.getTitle());
        notification.setContent(updateDto.getContent());
        return notificationRepositroy.save(notification).getNeedId();
    }

    public void deleteNeed(Long NeedId){

        notificationRepositroy.deleteById(NeedId);
    }


    public Notification findByNotificationId(Long notificationId){
        return notificationRepositroy.findById(notificationId)
                .orElseThrow(()->new
                        BusinessLogicException(ExceptionCode.NEED_NOT_FOUND));
    }




}
