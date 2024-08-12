package com.gdsc.cmd.domain.need.dto;

import com.gdsc.cmd.domain.need.domain.Need;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class NeedResponseDto {
    private Long needId;
    private String title;
    private String content;

    public static NeedResponseDto FindFromNeed(Need need) {
        return new NeedResponseDto(need.getNeedId(),
                                need.getTitle(),
                                need.getContent());
    }
}
