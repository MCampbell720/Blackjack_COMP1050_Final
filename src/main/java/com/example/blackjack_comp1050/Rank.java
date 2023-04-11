package com.example.blackjack_comp1050;

import java.util.Arrays;
import java.util.Collections;

public class Rank {

    //Variables
    private String name;
    private String symbol;

    //Constructors
    private Rank( String name, String symbol ) {
        this.name = name;
        this.symbol = symbol;
    }
    //Initialize the 13 possible card values
    public final static Rank ACE = new Rank( "Ace", "a" );
    public final static Rank TWO = new Rank( "Two", "2" );
    public final static Rank THREE = new Rank( "Three", "3" );
    public final static Rank FOUR = new Rank( "Four", "4" );
    public final static Rank FIVE = new Rank( "Five", "5" );
    public final static Rank SIX = new Rank( "Six", "6" );
    public final static Rank SEVEN = new Rank( "Seven", "7" );
    public final static Rank EIGHT = new Rank( "Eight", "8" );
    public final static Rank NINE = new Rank( "Nine", "9" );
    public final static Rank TEN = new Rank( "Ten", "t" );
    public final static Rank JACK = new Rank( "Jack", "j" );
    public final static Rank QUEEN = new Rank( "Queen", "q" );
    public final static Rank KING = new Rank( "King", "k" );

    //Methods
    public String getSymbol() {
        return symbol;
    }
    //Needed for deck iterator
    public final static java.util.List VALUES =
            Collections.unmodifiableList( Arrays.asList( new Rank[] { ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN,
                    EIGHT, NINE, TEN, JACK, QUEEN, KING } ) );
}