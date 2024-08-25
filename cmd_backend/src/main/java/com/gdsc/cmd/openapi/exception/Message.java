package com.gdsc.cmd.openapi.exception;

import com.gdsc.cmd.openapi.domain.type.StatusEnum;
import lombok.Data;

@Data // gatter,setter 등 여러 유용한거 짬뽕시켜논 어노테이션.
public class Message extends Throwable {

    private StatusEnum status;
    private String message;
    private Object jsonData;

    public Message() { //기본생성자를 이용하여 기본값을 설정해줌.
        this.status = StatusEnum.OK;
        this.message = null;
    }
}
