package com.gdsc.cmd.openapi.domain.type;

import lombok.Getter;

public enum StatusEnum {

        OK(200,"loaded successfull"),
        FAIL(500,"loaded fail");



        private int code;
        private String message;

        StatusEnum(int code, String message) {
                this.code = code;
                this.message = message;
        }

}
