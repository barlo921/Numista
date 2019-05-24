package com.barlo.numista.view;

import javafx.fxml.FXML;
import javafx.scene.text.Text;


public class CoinViewController {

    private static NumistaFxmlController.CoinData coinData;

    @FXML private Text coinNameText;
    @FXML private Text collectionText;
    @FXML private Text subcollectionText;
    @FXML private Text yearText;
    @FXML private Text countryText;
    @FXML private Text descriptionText;

    @FXML
    public void initialize() {
        coinData = NumistaFxmlController.getEditingCoin();

        coinNameText.setText(coinData.getCoin());
        collectionText.setText(coinData.getCollection());
        subcollectionText.setText(coinData.getSubcollection());
        yearText.setText(coinData.getYear());
        countryText.setText(coinData.getCountry());
        descriptionText.setText(coinData.getDescription());
    }

    public void editCoin() {

    }
}
