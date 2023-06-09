package com.example.blackjack_comp1050;

import javafx.scene.image.Image;

public class Card {
    //Variables
    private Suit suit;
    private Rank rank;
    private Image card;

    //Constructors
    public Card(Suit suit, Rank rank, Image cardFace) {
        this.card = cardFace;
        this.suit = suit;
        this.rank = rank;
    }

    //Methods
    public Image getCard() {
        return card;
    }
    public Rank getRank() {
        return rank;
    }

    //Initializes each of the 52 cards with names of the value of the card (1,2,K,A...) then suit (C,D,S,H), i.e. 2 of Hearts is 2H.
    public static String initializeCard(Suit suit, Rank rank) {
        return "C:/Users/campbellm7/OneDrive - Wentworth Institute of Technology/Computer Science II/Blackjack_COMP1050_Final/src/main/resources/com/example/blackjack_comp1050/" + rank.getSymbol() + suit.getSymbol() + ".gif";
    }

    //Returns value of the selected card (2-10 are self-explanatory, but A, K, Q, J cause issues) Ace will be a constant 11 for this project and K, J, Q will have values of 10.
    public int getValue() {
        String var = this.rank.getSymbol();
        try {
            //If the value is 2-10, it will be converted into an int,
            return Integer.parseInt(var);
        } catch (Exception ex) {
            //If value is 1,K,Q,J...
            if (var.equals("a")) {
                //Card is ace, so value will be 11,
                return 11;
            } else {
                //Card is J, Q, or K so value is 10.
                return 10;
            }
        }
    }
}