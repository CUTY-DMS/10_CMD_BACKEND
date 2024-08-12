package com.gdsc.cmd.domain.notification.controller;

import com.gdsc.cmd.domain.notification.dto.NotificationPostRequestDto;
import com.gdsc.cmd.domain.notification.dto.NotificationResponseDto;
import com.gdsc.cmd.domain.notification.dto.NotificationUpdateDto;
import com.gdsc.cmd.domain.notification.domain.repository.NotificationRepositroy;
import com.gdsc.cmd.domain.notification.service.NotificationService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Getter @Setter
@RequestMapping("/api/need")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;
    private final NotificationRepositroy notificationRepositroy;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Long postNeed(@RequestBody @Validated NotificationPostRequestDto postDto){
        Long notificationId = notificationService.postneed(postDto);
        return notificationId; //응답 상태:created, body 내용:NeedId
    }

    @GetMapping("/{needId}")
    public ResponseEntity readNeed(@PathVariable("needId")Long needId){
        NotificationResponseDto notificationResponseDto = notificationService.findByNeedId(needId);
                return ResponseEntity.status(HttpStatus.OK).body(notificationResponseDto);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PatchMapping("/{needId}")
    public Long updateNeed(@PathVariable("needId") Long needId,
                                     @RequestBody @Validated NotificationUpdateDto notificationUpdateDto)
    {
        return notificationService.updateNeed(notificationUpdateDto,needId);
    }

    @DeleteMapping("/{needId}")
    public ResponseEntity deleteNeed(@PathVariable("needId")Long needId){
        notificationService.deleteNeed(needId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
