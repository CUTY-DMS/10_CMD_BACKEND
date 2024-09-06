package com.gdsc.cmd.domain.notification.controller;

import com.gdsc.cmd.domain.notification.dto.NotificationCreateRequestDto;
import com.gdsc.cmd.domain.notification.dto.NotificationFindResponseDto;
import com.gdsc.cmd.domain.notification.dto.NotificationFindAllResponse;
import com.gdsc.cmd.domain.notification.dto.NotificationUpdateRequestDto;
import com.gdsc.cmd.domain.notification.domain.repository.NotificationRepositroy;
import com.gdsc.cmd.domain.notification.service.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationRepositroy notificationRepositroy;
    private final NotificationCreateService notificationCreateService;
    private final NotificationReadService notificationReadService;
    private final NotificationUpdateService notificationUpdateService;
    private final NotificationDeleteService notificationDeleteService;
    private final NotificationFindAllService notificationFindAllService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping
    public void createNotification(@RequestBody @Validated NotificationCreateRequestDto postDto){
      notificationCreateService.postNotification(postDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{notificationId}")
    public NotificationFindResponseDto readNotification(@PathVariable("notificationId")Long needId){
         return notificationReadService.readNotification(needId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{notificationId}")
    public void updateNotification(@PathVariable("notificationId") Long needId,
                                   @RequestBody @Validated NotificationUpdateRequestDto notificationUpdateRequestDto)
    {
        notificationUpdateService.updateNotification(notificationUpdateRequestDto,needId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{notificationId}")
    public void deleteNotification(@PathVariable("notificationId")Long needId){
        notificationDeleteService.deleteNotification(needId);

    }

    @GetMapping
    public List<NotificationFindAllResponse> findAllNotification(){
        return notificationFindAllService.findAll();
    }


}
