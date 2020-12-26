package com.spart.week03.service;

import com.spart.week03.models.Product;
import com.spart.week03.models.ProductMypriceRequestDto;
import com.spart.week03.models.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Long update(Long id, ProductMypriceRequestDto mypriceRequestDto){
        Product product = productRepository.findById(id).orElseThrow(
                () ->new NullPointerException("아이디가 없습니다.")
        );
        product.update(mypriceRequestDto);
        return id;

    }
}
