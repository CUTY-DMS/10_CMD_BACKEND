package com.gdsc.cmd.domain.need.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class NeedReadDto {
    private Long needId;
    private String title;
    private String content;

    public static NeedReadDto fromDto(NeedReadDto dto) {

    }
}
