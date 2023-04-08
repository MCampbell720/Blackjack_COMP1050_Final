package com.example.blackjack_comp1050;

public final class Suit {

    //Variables
    private String name;
    private String symbol;

    //Constructors
    private Suit( String nameValue, String symbolValue ) {
        name = nameValue;
        symbol = symbolValue;
    }
    //Initialize the four suits
    public final static Suit CLUB = new Suit("Clubs", "c");
    public final static Suit SPADE = new Suit("Spades", "s");
    public final static Suit HEART = new Suit("Hearts", "h");
    public final static Suit DIAMONDS = new Suit("Diamonds", "d");

    //Methods
    public String getName() {
        return name;
    }
    public String getSymbol() {
        return symbol;
    }
}
