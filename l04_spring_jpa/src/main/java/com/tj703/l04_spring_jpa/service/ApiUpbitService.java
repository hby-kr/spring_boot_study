package com.tj703.l04_spring_jpa.service;

import com.tj703.l04_spring_jpa.dto.CoinDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class ApiUpbitService {

    // 서버 사이드 api 불러오기
    private final RestTemplate restTemplate = new RestTemplate();

    public CoinDto[] readCoins() {
        String url = "https://api.upbit.com/v1/market/all?is_details=true";
        CoinDto[] response = restTemplate.getForObject(url, CoinDto[].class);
        System.out.println(Arrays.toString(response));
        return response;
    }



}
