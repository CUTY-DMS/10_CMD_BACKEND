package com.gdsc.cmd.domain.notification.service;


import com.gdsc.cmd.domain.notification.domain.Notification;
import com.gdsc.cmd.domain.notification.domain.repository.NotificationRepositroy;
import com.gdsc.cmd.domain.notification.dto.NotificationListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class NotificationFindAllService {
   private final NotificationRepositroy notificationRepositroy;


   public List<NotificationListResponseDto> findAll(){
    List<Notification> entityList = notificationRepositroy.findAll(); //먼져 공지 엔티티의 DB 행값들을 다 넣어줌.

      List<NotificationListResponseDto> dtoList = new ArrayList<>();

    for(int i=0 ; i<entityList.size() ; i++){
       NotificationListResponseDto notificationListResponseDto = NotificationListResponseDto.builder()
               .title(entityList.get(i).getTitle())
               .createdTime(entityList.get(i).getCreatedTime())
               .build();
       dtoList.add(notificationListResponseDto);
      }

    return dtoList;
   }
}
