package com.gdsc.cmd.domain.notification.dto;

import com.gdsc.cmd.domain.notification.domain.Notification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class NotificationFindRequestDto {
    private Long needId;
    private String title;
    private String content;

    public static NotificationFindRequestDto FindFromNeed(Notification notification) {
        return new NotificationFindRequestDto(notification.getNeedId(),
                                notification.getTitle(),
                                notification.getContent());
    }
}
