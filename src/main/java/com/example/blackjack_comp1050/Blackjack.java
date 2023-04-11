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

public class Blackjack extends Application {
    //Initialization
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
    Image imagebackground = new Image("C:/Users/campbellm7/OneDrive - Wentworth Institute of Technology/Computer Science II/Blackjack_COMP1050_Final/src/main/resources/com/example/blackjack_comp1050/table.png");
    //Extra methods
    //Shuffle
    public void newDeck() {
        deck.restoreDeck();
        deck.shuffle();
        System.out.println("The deck has been shuffled!");
        status.setText("The deck has been shuffled!");
    }
    //New game
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
        status.setText("Your turn!");
    }
    public void draw(Player player, FlowPane pane, Label l){
        try{
            Card card = deck.deal();
            ImageView img = new ImageView(card.getCard());
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
    //Game
    @Override
    public void start(Stage primaryStage) {
        //Text colors and fonts
        totalLabel.setFont(new Font("Papyrus", 24));
        totalLabel.setTextFill(Color.web("#FFF"));
        totalDealerLabel.setFont(new Font("Papyrus", 24));
        totalDealerLabel.setTextFill(Color.web("#FFF"));
        status.setTextFill(Color.web("#FFF"));
        status.setFont(new Font("Papyrus", 24));
        dealerLabel.setTextFill(Color.web("#FFF"));
        dealerLabel.setFont(new Font("Papyrus", 24));
        playerLabel.setTextFill(Color.web("#FFF"));
        playerLabel.setFont(new Font("Papyrus", 24));
        //Background Setup
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imagebackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        //Hit Button
        Button drawbtn = new Button();
        drawbtn.setText("Hit");
        //If player turn and not busted...
        drawbtn.setOnAction((e) -> {
            if(isTurn == true && isBust != true){
                draw(player, cards, totalLabel);

                if(player.getTotal() > 21){
                    //Big Bust
                    System.out.println("Bust");
                    isBust = true;
                    isTurn = false;
                    status.setText("Bust");
                }
            }
        });
        //Stand Button
        Button standbtn = new Button();
        standbtn.setText("Stand");
        //Blackjack logic
        standbtn.setOnAction((e) -> {
            if(isTurn == true && isBust != true){
                isTurn = false;
                while(dealer.getTotal() < 17){
                    draw(dealer, dealerCards, totalDealerLabel);
                }

                int playerTotal = player.getTotal();
                int dealerTotal = dealer.getTotal();

                System.out.println("Player: "+player);
                System.out.println("Dealer: "+dealer);

                if(dealerTotal <= 21 && playerTotal == dealerTotal){
                    // tie, push
                    System.out.println("Push");
                    status.setText("Push");
                } else if(dealerTotal <= 21 && playerTotal <= dealerTotal){
                    // you lost
                    System.out.println("You lose!");
                    status.setText("You lose!");
                } else if(deck.getRemaining() < 5) {
                    System.out.println("The deck has been shuffled!");
                    status.setText("The deck has been shuffled!");
                } else {
                    // you won
                    System.out.println("You win!");
                    status.setText("You win!");
                }
            }
        });
        //Deal button
        Button newbtn = new Button();
        newbtn.setText("New Hand");
        newbtn.setOnAction((e) -> {
            newPlayer();
        });
        //Grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5);
        grid.add(dealerCards, 0, 0, 3, 1);
        grid.add(dealerLabel, 0, 1);
        grid.add(totalDealerLabel, 1, 1, 2, 1);
        //Padding
        Pane p = new Pane();
        p.setPrefSize(0, 100);
        grid.add(p, 0, 2);
        grid.add(cards, 0, 3, 3, 1);
        grid.add(playerLabel, 0, 4);
        grid.add(totalLabel, 1, 4, 2, 1);
        grid.add(drawbtn,0,5);
        grid.add(standbtn,1,5);
        grid.add(newbtn, 2, 5);
        grid.add(status, 0, 6, 3, 1);
        grid.setBackground(background);
        //Resolution
        Scene scene = new Scene(grid, 1200, 675);
        //Window
        primaryStage.setTitle("COMP1050 - Blackjack");
        primaryStage.setScene(scene);
        primaryStage.show();
        newDeck();
        newPlayer();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
