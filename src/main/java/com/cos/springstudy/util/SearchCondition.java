package com.cos.springstudy.util;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchCondition {

    private String option;   // 제목, 내용, 제목+내용
    private String keyword;  // 검색어
    private int page = 1;    // 현재 페이지
}
