package com.spart.week03.models;

import lombok.Getter;

@Getter
public class ProductRequestDto {
    private String title;   //제목
    private String link;    //링크
    private String image;   //이미지
    private int lprice;     //최저가
}

