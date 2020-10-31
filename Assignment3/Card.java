package com.bham.pij.assignments.pontoon;;


import java.util.*;
public class Card {
    public boolean dealt;
    private String suit;
    private String value;

    public Card (String suit, String value) {
        this.suit = suit;
        this.value = value;
         this.dealt = false;
    }
    Random rand = new Random();
    ArrayList<Integer> getNumericalValue(){
        ArrayList<Integer> values = new ArrayList<>();

        if (this.value.equalsIgnoreCase("TWO")){
            values.add(2);
        }
        else if (this.value.equalsIgnoreCase("THREE")){
            values.add(3);
        }
        else if (this.value.equalsIgnoreCase("FOUR")){
            values.add(4);
        }
        else if (this.value.equalsIgnoreCase("FIVE")){
            values.add(5);
        }
        else if (this.value.equalsIgnoreCase("SIX")){
            values.add(6);
        }
        else if (this.value.equalsIgnoreCase("SEVEN")){
            values.add(7);
        }
        else if (this.value.equalsIgnoreCase("EIGHT")){
            values.add(8);
        }
        else if (this.value.equalsIgnoreCase("NINE")){
            values.add(9);
        }
         else if (this.value.equalsIgnoreCase("TEN")|| this.value.equalsIgnoreCase("jack") || this.value.equalsIgnoreCase("queen") || this.value.equalsIgnoreCase("king")){
            values.add(10);
         }
         else if(this.value.equalsIgnoreCase("ace")){
            values.add(11);
            values.add(1);
        }
         return values;
    }
    String getSuit(){
        return suit;
    }
    String getValue(){
        return value;
    }
    public String toString(){
        return (value+" " + suit);
    }
    static String getRandomSuit(){
        Random rand = new Random();
        String [] suits = {"HEARTS","SPADES","CLUBS","DIAMONDS"};
        int r = rand.nextInt(3);
        return suits[r];
    }
    static String getRandomValue(){
        Random rand = new Random();
        String[] values = {"TWO", "THREE", "FOUR", "FIVE", "SIX",
                "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING", "ACE"};
        int r = rand.nextInt(values.length-1);
        ArrayList<String> betterValuesArray = new ArrayList<String>(Arrays.asList(values));
        return betterValuesArray.get(r);
    }
}
