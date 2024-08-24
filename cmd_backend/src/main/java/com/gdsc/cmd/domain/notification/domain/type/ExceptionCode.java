package com.gdsc.cmd.domain.notification.domain.type;

import lombok.Getter;

public enum ExceptionCode {
    NOTIFICATION_NOT_FOUND(404,"notification not found");

    @Getter
    private int status;
    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
