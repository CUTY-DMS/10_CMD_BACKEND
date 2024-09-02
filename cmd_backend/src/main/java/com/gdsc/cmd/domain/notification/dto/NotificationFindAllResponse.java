package com.gdsc.cmd.domain.notification.dto;

import com.gdsc.cmd.domain.notification.domain.Notification;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;


@Getter
public class NotificationFindAllResponse {

    @NotEmpty
    private String title;

    @NotEmpty
    private LocalDate createdTime;

    public NotificationFindAllResponse(Notification notification) {
        this.title = notification.getTitle();
        this.createdTime = notification.getCreatedTime();
    }
}
