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
    private int viewCnt;
}
