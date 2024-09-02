package com.gdsc.cmd.domain.notification.dto;

import com.gdsc.cmd.domain.notification.domain.Notification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;



public class NotificationListResponseDto {

    @NotEmpty
    private String title;

    @NotEmpty
    private LocalDate createdTime;

    public NotificationListResponseDto(Notification notification) {
        this.title = notification.getTitle();
        this.createdTime = notification.getCreatedTime();
    }
}
