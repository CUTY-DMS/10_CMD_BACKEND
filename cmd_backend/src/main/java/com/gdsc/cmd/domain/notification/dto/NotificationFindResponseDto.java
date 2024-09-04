package com.gdsc.cmd.domain.notification.dto;

import com.gdsc.cmd.domain.notification.domain.Notification;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NotificationFindResponseDto {
    private Long notificationId;
    private String title;
    private String content;

    public static NotificationFindResponseDto FindFromNotification(Notification notification) {
        return new NotificationFindResponseDto(notification.getNotificationId(),
                                notification.getTitle(),
                                notification.getContent());
    }
}
