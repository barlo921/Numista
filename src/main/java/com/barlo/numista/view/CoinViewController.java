package com.barlo.numista.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;


public class CoinViewController {

    private static NumistaFxmlController.CoinData coinData;
    private static Stage thisStage;

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

        thisStage = NumistaFxmlController.getNewWindowStage();
        InputStream fxmlStream;

        try {
            fxmlStream = getClass().getClassLoader().getResourceAsStream("fxml/coinUpdateTemplateFXML.fxml");
            FXMLLoader loader = new FXMLLoader();
            loader.load(fxmlStream);
            thisStage.setScene(new Scene(loader.getRoot()));
        } catch (IOException e) {
            throw new RuntimeException("This should never happen");
        }

    }
}
