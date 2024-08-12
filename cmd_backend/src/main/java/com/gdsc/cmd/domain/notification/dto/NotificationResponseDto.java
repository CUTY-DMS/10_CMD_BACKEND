package com.gdsc.cmd.domain.notification.dto;

import com.gdsc.cmd.domain.notification.domain.Notification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class NotificationResponseDto {
    private Long needId;
    private String title;
    private String content;

    public static NotificationResponseDto FindFromNeed(Notification notification) {
        return new NotificationResponseDto(notification.getNeedId(),
                                notification.getTitle(),
                                notification.getContent());
    }
}
