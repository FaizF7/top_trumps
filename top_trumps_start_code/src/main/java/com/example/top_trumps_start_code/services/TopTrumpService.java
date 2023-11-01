package com.example.top_trumps_start_code.services;

import com.example.top_trumps_start_code.models.Card;
import com.example.top_trumps_start_code.models.Reply;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TopTrumpService {

    public TopTrumpService() {
    }

    public Reply checkWinner(ArrayList<Card> cards){

        Card card0 = cards.get(0);
        Card card1 = cards.get(1);

        if (card0.getCardValue()==card1.getCardValue()){
            return new Reply("It's a draw!");
        }

        Card winner = card0.getCardValue()>card1.getCardValue()? card0:card1;

        String message = String.format("%s of %s wins!", winner.getRank(), winner.getSuit());
        return new Reply(message);
    }


}
