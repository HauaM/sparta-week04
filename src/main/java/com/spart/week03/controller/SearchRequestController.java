package com.spart.week03.controller;

import com.spart.week03.models.ItemDto;
import com.spart.week03.utils.NaverShopSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchRequestController {
    private final NaverShopSearch naverShopSearch;

    @GetMapping("/api/search")
    public List<ItemDto> execSearch(@RequestParam String query){
        String result = naverShopSearch.search(query);

        return naverShopSearch.fromJSONtoItems(result);
    }
}

