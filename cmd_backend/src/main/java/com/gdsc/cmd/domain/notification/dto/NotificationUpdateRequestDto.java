package com.gdsc.cmd.domain.notification.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
public class NotificationUpdateRequestDto {
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
}
