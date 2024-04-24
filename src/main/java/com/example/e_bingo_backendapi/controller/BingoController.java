package com.example.e_bingo_backendapi.controller;
import com.example.e_bingo_backendapi.service.BingoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BingoController {

    private final BingoService bingoService;

    @Autowired
    public BingoController(BingoService bingoService) {
        this.bingoService = bingoService;
    }

    // get random card
    @GetMapping("/generateCard")
    public ResponseEntity<String> hello() {
        ResponseEntity<String> response = bingoService.getCard();
        System.out.println("response = " + response);
        return response;
    }

    // ${BASE.URL}/winningCard?playerToken=playerToken
    @GetMapping("/winningCard")
    public ResponseEntity<String> winningCard(@RequestParam String playerToken) {
        ResponseEntity<String> response = bingoService.checkWinningCard(playerToken);
        System.out.println("response = " + response);
        return response;
    }
}
