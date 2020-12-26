package com.spart.week03.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class ItemDto {
    /*private final String title;
    private final String image;
    private final String link;
    private final int lprice;*/

    private String title;
    private String image;
    private String link;
    private int lprice;

    public ItemDto(JSONObject jsonObject){
        this.title = jsonObject.getString("title");
        this.image = jsonObject.getString("image");
        this.link = jsonObject.getString("link");
        this.lprice = jsonObject.getInt("lprice");
    }
}
