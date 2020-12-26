package com.spart.week03.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor //기본생성자 만들기 직렬화를 위해 꼭 필요하다.
public class Product /*extends  Timestamped*/{

    @GeneratedValue(strategy = GenerationType.AUTO) //id 가 자동으로 증가하여 생성됨
    @Id //pk 임을 나타탬
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private int lprice;

    @Column(nullable = false)
    private int myprice;

    public Product(ProductRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.image = requestDto.getImage();
        this.link = requestDto.getLink();
        this.lprice = requestDto.getLprice();
        this.myprice = 0;
    }

    public Product(ProductMypriceRequestDto productMypriceRequestDto) {
        this.myprice = productMypriceRequestDto.getMyprice();
    }

    public void update(ProductMypriceRequestDto mypriceRequestDto){
        this.myprice = mypriceRequestDto.getMyprice();
    }

}

