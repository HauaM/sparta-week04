package com.spart.week03.utils;

import com.spart.week03.models.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class NaverShopSearch {
    public String search(String query) {

        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "dWMxBOiscPZr4e5CXWyd");
        headers.add("X-Naver-Client-Secret", "b2ZgBXnbHd");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" + query, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);
        return response;

    }

    public static void main(String[] args) {
        NaverShopSearch naverShopSearch = new NaverShopSearch();
        String result = naverShopSearch.search("아이맥");

        naverShopSearch.fromJSONtoItems(result);
    }

    /*
     * 1. 네이버에서 넘긴 전체 소스는 String 형태로 넘어온다.
     * 2. String 형태로 넘어 온 것 중 우리에게 필요한  정보 items는 우리가 선언한  JSON 타입으로 들어와있다.
     * 3. items를 추출 해야된다(우리에게 필요한 정보만을 화면에 전송하기 위해서)
     * 4. JSONObject에 items의 값을 담는다.
     * 5. JSONObject에 담긴 형태를 보니 ["key" : "value", "key":"velue", ...] 형태의 모습이다 이것은 배열의 형태이다.
     * 6. 배열형태로 들어간 값을 key"item"을 통해 추출 후  JSONArray에 담아 낸다.
     * 7. JSONArray의 값을 반복문을 통해 하니씩 JSONObject에 담아 낸다.
     * 8. JSONObject에서 우리에게 필요한 값을 사전에 선언한 ItemDto에 담는다.
     * 9. 우리가 화면에 반환해야될 값은 한가지 값만이 아닌 List 형태로 여러 JSON타입의 데이터를 보내야 된다.
     * 10. 우리가 데이터를 한번에 여러게 보내기 위해 List에 우리가 선언한 DTO를 담아서 보내기 위한 변수를 선언한다.
     * 11. DTO를 통해 각각 담긴 값을 다시 List형태로 만들어 준다.
     */
    //1번
    public List<ItemDto> fromJSONtoItems(String result){
        //2번
        JSONObject jsonObject = new JSONObject(result);

        //6번
        JSONArray jsonArray = jsonObject.getJSONArray("items");

        System.out.println("제이슨 어레이 === " + jsonArray.toString());

        //10번
        List<ItemDto> resultList = new ArrayList<>();

        //7번
        for(int i = 0; i < jsonArray.length(); i++){
            JSONObject object = jsonArray.getJSONObject(i);
            System.out.println(object);
            //8번
            ItemDto itemDto = new ItemDto(object);
            System.out.println("itemDto === " + itemDto.toString());

            //11번
            resultList.add(itemDto);
        }

        return resultList;
    }
}