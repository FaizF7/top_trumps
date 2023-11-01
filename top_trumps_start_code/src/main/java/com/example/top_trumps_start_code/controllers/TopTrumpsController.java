package com.example.top_trumps_start_code.controllers;

import com.example.top_trumps_start_code.models.Card;
import com.example.top_trumps_start_code.models.Reply;
import com.example.top_trumps_start_code.services.TopTrumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/games")
public class TopTrumpsController {

    @Autowired
    TopTrumpService topTrumpService;

    @PostMapping
    public ResponseEntity<Reply> placeCards(@RequestBody ArrayList<Card> cards){
        Reply reply = topTrumpService.checkWinner(cards);
        return new ResponseEntity<>(reply, HttpStatus.CREATED);
    }

}
