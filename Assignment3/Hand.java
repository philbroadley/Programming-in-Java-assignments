package com.bham.pij.assignments.pontoon;
import java.util.*;


public class Hand {
    private ArrayList<Card> inHand;
    public Hand() {
        this.inHand =new ArrayList<>();

    }

    public void addCard(Card c) {
        inHand.add(0,c);
    }

    public Card getCard(int i) {
        return inHand.get(i);
    }

    public int getHandSize(){
        return inHand.size();
    }

    public ArrayList<Integer> getNumericalValue() {
        ArrayList<Integer> numericalValues = new ArrayList<>();
        numericalValues.add(0);

        for(Card c:inHand){

            if (c.getNumericalValue().size()==1){
                for (Integer i:numericalValues) {
                    numericalValues.set(numericalValues.indexOf(i),i+c.getNumericalValue().get(0));
                }
            } else if(c.getNumericalValue().size()==2){

                for (int i = 0; i < numericalValues.size(); i++) {
                    numericalValues.set(i,numericalValues.get(i)+1);
                }
                numericalValues.add(0,numericalValues.get(0)+10);

            }
        }

        return numericalValues;
    }

    public String showHand() {
        String handString = "";
        for(Card c:inHand){
            if(!(inHand.get(0)==c)){
                handString+=", ";
            }
            handString+=c.toString();
        }
        return handString;
    }
}
