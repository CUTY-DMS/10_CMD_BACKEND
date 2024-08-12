package com.gdsc.cmd.domain.notification.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class NotificationPostRequestDto {

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;
}
