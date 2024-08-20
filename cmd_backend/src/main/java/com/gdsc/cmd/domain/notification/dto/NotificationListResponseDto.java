package com.gdsc.cmd.domain.notification.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;


@AllArgsConstructor
@Builder
public class NotificationListResponseDto {
    @NotEmpty
    private String title;

    @NotEmpty
    private LocalDate createdTime;


}
