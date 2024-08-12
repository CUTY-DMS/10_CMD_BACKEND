package com.gdsc.cmd.domain.notification.service;


import com.gdsc.cmd.domain.notification.domain.Notification;
import com.gdsc.cmd.domain.notification.domain.type.ExceptionCode;
import com.gdsc.cmd.domain.notification.dto.NotificationPostRequestDto;
import com.gdsc.cmd.domain.notification.dto.NotificationResponseDto;
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


    public NotificationResponseDto findByNeedId(Long needId){
        Notification notification = findNeedId(needId);
        return NotificationResponseDto.FindFromNeed(notification);
    }


    @Transactional
    public Long updateNeed(NotificationUpdateDto updateDto, Long needId ){
        Notification notification = findNeedId(needId);
        notification.setTitle(updateDto.getTitle());
        notification.setContent(updateDto.getContent());
        return notificationRepositroy.save(notification).getNeedId();
    }

    public void deleteNeed(Long NeedId){

        notificationRepositroy.deleteById(NeedId);
    }


    public Notification findNeedId(Long needId){
        return notificationRepositroy.findById(needId)
                .orElseThrow(()->new
                        BusinessLogicException(ExceptionCode.NEED_NOT_FOUND));
    }




}
