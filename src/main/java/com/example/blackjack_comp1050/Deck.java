package com.example.blackjack_comp1050;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Deck {

    //Variables
    private java.util.List deck;
    private int var;
    //Constructors
    public Deck(){ this(1); }
    public Deck(int numDecks) {
        deck = new ArrayList();
        var = 0;
        //Iterators to create the deck of 52 cards, one for each rank and suit combination.
        try{
            for(int i = 0; i<numDecks; i++){
                Iterator suitIterator = Suit.VALUES.iterator();
                while ( suitIterator.hasNext() ) {
                    Suit suit = (Suit) suitIterator.next();
                    Iterator rankIterator = Rank.VALUES.iterator();
                    while ( rankIterator.hasNext() ) {
                        Rank rank = (Rank) rankIterator.next();
                        Card card = new Card( suit, rank, new Image(Card.initializeCard( suit, rank )) );
                        addCard( card );
                    }
                }
            }
            shuffle();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    //Methods
    public void addCard( Card card ) {
        deck.add( card );
    }
    public int getSize() {
        return deck.size();
    }
    public int getRemaining() {
        return deck.size() - var;
    }
    public Card deal() {
        if ( var >= deck.size() )
            return null;
        else
            return (Card) deck.get( var++ );
    }
    public boolean isEmpty() {
        if ( var >= deck.size() )
            return true;
        else
            return false;
    }
    public void shuffle() {
        Collections.shuffle( deck );
    }
    public void restoreDeck() {
        var = 0;
    }
}
