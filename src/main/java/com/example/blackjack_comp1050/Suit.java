package com.example.blackjack_comp1050;

import java.util.Arrays;
import java.util.Collections;

public final class Suit {

    //Variables
    private String name;
    private String symbol;

    //Constructors
    private Suit( String name, String symbol ) {
        this.name = name;
        this.symbol = symbol;
    }
    //Initialize the four suits
    public final static Suit CLUBS = new Suit("Clubs", "c");
    public final static Suit SPADES = new Suit("Spades", "s");
    public final static Suit HEARTS = new Suit("Hearts", "h");
    public final static Suit DIAMONDS = new Suit("Diamonds", "d");

    //Methods
    public String getName() {
        return name;
    }
    public String getSymbol() {
        return symbol;
    }
    //Needed for deck iterator
    public final static java.util.List VALUES =
            Collections.unmodifiableList(
                    Arrays.asList( new Suit[] { CLUBS, DIAMONDS, HEARTS, SPADES } ) );
}
