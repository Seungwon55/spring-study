package com.cos.springstudy.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class PageHandler {

    private SearchCondition sc;
    private int totalCnt;                     // 전체 게시물 수
    private int totalPage;                    // 전체 페이지 수
    private static final int PAGE_SIZE = 10;  // 한 페이지의 게시물 수
    private static final int NAVI_SIZE = 10;  // 한 페이지의 페이지 수
    private int beginPage;                    // 시작 페이지
    private int endPage;                      // 마지막 페이지
    private int offset;
    private boolean showPrevBlock;            // 10페이지 이전 버튼 보일지 여부
    private boolean showPrev;                 // 이전 페이지 버튼 보일지 여부
    private boolean showNext;                 // 다음 페이지 버튼 보일지 여부
    private boolean showNextBlock;            // 10페이지 다음 버튼 보일지 여부

    public PageHandler(SearchCondition sc, int totalCnt) {
        this.sc = sc;
        this.totalCnt = totalCnt;
        totalPage = (totalCnt - 1) / PAGE_SIZE + 1;
        beginPage = (sc.getPage() - 1) / NAVI_SIZE * NAVI_SIZE + 1;
        endPage = Math.min(beginPage + NAVI_SIZE -1, totalPage);
        offset = (sc.getPage() - 1) * PAGE_SIZE;
        showPrevBlock = sc.getPage() > 10;
        showPrev = sc.getPage() > 1;
        showNext = sc.getPage() < totalPage;
        showNextBlock = (sc.getPage() + 10) <= totalPage;
    }
}
