package com.gdsc.cmd.domain.notification.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter @Setter
public class NotificationUpdateDto {
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
}
