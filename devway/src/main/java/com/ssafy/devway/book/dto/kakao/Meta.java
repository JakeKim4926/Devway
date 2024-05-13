package com.ssafy.devway.book.dto.kakao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class Meta {

    private Integer total_count;
    private Integer pageable_count;
    private Boolean is_end;
}
