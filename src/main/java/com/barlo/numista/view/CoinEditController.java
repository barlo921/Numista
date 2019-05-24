package com.barlo.numista.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CoinEditController {

    private static Stage thisStage;
    private static NumistaFxmlController.CoinData coinData;

    @FXML private TextField coinNameField;
    @FXML private TextField collectionField;
    @FXML private TextField subcollectionField;
    @FXML private TextField yearField;
    @FXML private TextField countryField;
    @FXML private TextField descriptionField;

    public void initialize(){

        coinData = NumistaFxmlController.getEditingCoin();

        coinNameField.setText(coinData.getCoin());
        collectionField.setText(coinData.getCollection());
        subcollectionField.setText(coinData.getSubcollection());
        yearField.setText(coinData.getYear());
        countryField.setText(coinData.getCountry());
        descriptionField.setText(coinData.getDescription());

    }

    public void saveCoin(){

    }

    public void browseImage(){

    }

}
