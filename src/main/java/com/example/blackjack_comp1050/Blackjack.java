package com.example.blackjack_comp1050;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import static javafx.application.Application.launch;

public class Blackjack extends Application {
    //Main class that holds the gui and blackjack logic
    private final Deck deck = new Deck(1);
    private final Player player = new Player();
    private final Player dealer = new Player();
    private boolean isBust;
    private boolean isTurn;

    FlowPane cards = new FlowPane(Orientation.HORIZONTAL);
    FlowPane dealerCards = new FlowPane(Orientation.HORIZONTAL);
    Label totalLabel = new Label();
    Label totalDealerLabel = new Label();
    Label dealerLabel = new Label();
    Label playerLabel = new Label();
    Label status = new Label();
    Image imagebackground = new Image("C:\\Users\\campbellm7\\OneDrive - Wentworth Institute of Technology\Computer Science II\\Blackjack_COMP1050_Final\\src\\main\\resources\\com\\example\\blackjack_comp1050\\table.png");

    public void draw(Player player, FlowPane pane, Label l){
        try{
            Card card = deck.deal();
            ImageView img = new ImageView(card.initializeCard());
            pane.getChildren().add(img);
            player.addCard(card);
            int playerTotal = player.getTotal();
            StringBuilder total = new StringBuilder();
            if (player.getVal() > 0) {
                total.append(playerTotal-10).append("/");
            }
            total.append(playerTotal);
            l.setText(total.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void newDeck() {
        deck.restoreDeck();
        deck.shuffle();
        System.out.println("The Deck has been Shuffled!");
    }
    public void newPlayer() {
        if (deck.getRemaining() <= deck.getSize()*.2) {
            newDeck();
        }
        player.discardHand();
        dealer.discardHand();
        cards.getChildren().removeAll(cards.getChildren());
        dealerCards.getChildren().removeAll(dealerCards.getChildren());
        totalLabel.setText("");
        totalDealerLabel.setText("");
        isBust = false;
        isTurn = true;
        draw(player, cards, totalLabel);
        draw(dealer, dealerCards, totalDealerLabel);
        draw(player, cards, totalLabel);
        status.setText("Player's Turn!");
    }
    public static void main(String[] args) {
        launch(args);
    }
}
