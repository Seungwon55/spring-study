package com.cos.springstudy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@ToString
public class BoardDTO {

    private Integer bno;
    private String title;
    private String content;
    private Integer memberId;
    private LocalDateTime regDate;
    private Integer viewCnt;

    // 게시글 제목,내용 입력 확인
    public boolean inputCheck() {
        return title.isBlank() || content.isBlank();
    }
}
