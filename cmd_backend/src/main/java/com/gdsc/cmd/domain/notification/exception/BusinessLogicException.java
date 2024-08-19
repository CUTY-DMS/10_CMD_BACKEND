package com.gdsc.cmd.domain.notification.exception;

import com.gdsc.cmd.domain.notification.domain.type.ExceptionCode;
import lombok.Getter;

public class BusinessLogicException extends RuntimeException{
    @Getter
    private ExceptionCode exceptionCode;

    public BusinessLogicException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }
}
