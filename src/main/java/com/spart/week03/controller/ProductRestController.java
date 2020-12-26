package com.spart.week03.controller;

import com.spart.week03.models.Product;
import com.spart.week03.models.ProductRepository;
import com.spart.week03.models.ProductRequestDto;
import com.spart.week03.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //jpa 방식 자동응답기
@RequiredArgsConstructor //final로 선언된 멤버변수의 생성자를 자동으로 만들어준다.
public class ProductRestController {

    //RequiredArgsConstructor 어노테이션을 통해 변수 선언만으로도 생성자 선언이 필요가 없어진다.
    private final ProductRepository productRepository;

    private final ProductService service;

    @GetMapping("/api/products")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @PostMapping("/api/poducts")
    public Product createProducts(@RequestBody ProductRequestDto requestDto){

        Product product = new Product(requestDto);
        return productRepository.save(product);
    }


}



