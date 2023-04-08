package com.example.blackjack_comp1050;

import java.util.ArrayList;

public class Player {

    //Variables
    private int total;
    private int val;
    private java.util.List player = new ArrayList();

    //Constructors
    public void addCard( Card card ) {
        total += card.getValue();
        if(card.getRank() == Rank.ACE){
            val += 1;
        }
        if(val > 0){
            if(total > 21){
                total -= 10;
                val -= 1;
            }
        }
        player.add( card );
    }

    //Methods
    public int getVal(){
        return val;
    }
    public int getTotal(){
        return total;
    }
    public void discardHand() {
        player.clear();
        total = 0;
        val = 0;
    }
}