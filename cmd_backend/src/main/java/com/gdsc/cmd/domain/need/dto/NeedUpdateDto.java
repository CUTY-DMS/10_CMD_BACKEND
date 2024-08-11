package com.gdsc.cmd.domain.need.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter @Setter
public class NeedUpdateDto {
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
}
