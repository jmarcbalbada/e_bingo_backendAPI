package com.example.e_bingo_backendapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BingoService {

    private final RestTemplate restTemplate;

    @Autowired
    public BingoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> getCard() {
        String url = "http://www.hyeumine.com/getcard.php?bcode=HEelhJos";
        return restTemplate.getForEntity(url, String.class);
    }

    public ResponseEntity<String> checkWinningCard(String playerToken) {
        String url = "http://www.hyeumine.com/checkwin.php?playcard_token=" + playerToken;
        System.out.println("urk = " + url);
        return restTemplate.getForEntity(url, String.class);
    }


}
