package com.bham.pij.assignments.pontoon;

import java.util.*;

public class Deck {
    String [] values = {"TWO", "THREE", "FOUR", "FIVE", "SIX",
            "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING", "ACE"
    };
    String [] suits = {"HEARTS","SPADES","CLUBS","DIAMONDS"};
    private static ArrayList<Card> inDeck;


    public Deck () {
        inDeck=new ArrayList<Card>();
        for (String suit:suits) {
            for (String value : values) {
                inDeck.add(new Card(suit, value));
            }
        }
    }
    public void reset(){
        for (Card card:inDeck) {
            card.dealt = false;
        }
    }
    public int getDeckSize(){
        return inDeck.size();
    }
    public Card dealCard(int i){
        if (i>=inDeck.size()){
            return null;
        }
        else if (inDeck.get(i).dealt){
            return null;
        }
        Card card = inDeck.get(i);
        card.dealt = true;
        return card;
    }
    public Card getCard(int i){
        return inDeck.get(i);
    }

}
