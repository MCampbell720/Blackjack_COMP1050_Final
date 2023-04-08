module com.example.blackjack_comp1050 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.blackjack_comp1050 to javafx.fxml;
    exports com.example.blackjack_comp1050;
}