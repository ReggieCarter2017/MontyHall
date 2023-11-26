package com.example.montyhall;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class WindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField numberOfGamesTextField;

    @FXML
    private Text resultsText;

    @FXML
    private Button showResultsButton;

    int numberOfGames;

    boolean checker;



    @FXML
    void initialize() {
        MontyHallLogic montyHallLogic = new MontyHallLogic();

        numberOfGamesTextField.setOnAction(event -> {
            checker = true;
            if (checker) {
                try {
                    numberOfGames = Integer.parseInt(numberOfGamesTextField.getText());
                } catch (NumberFormatException e) {
                    resultsText.setText("\"" + e + "\" is invalid number.\nPlease, try again.");
                    checker = false;
                }
            }

        });

        showResultsButton.setOnAction(mouseEvent -> {
            if (checker)
            {
                resultsText.setText(montyHallLogic.run(numberOfGames));
            }
        });
    }

}
