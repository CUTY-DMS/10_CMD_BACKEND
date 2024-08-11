package com.gdsc.cmd.domain.need.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class NeedPostDto {

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;
}
