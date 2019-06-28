package com.barlo.numista.view;

import com.barlo.numista.NumistaConfiguration;
import com.barlo.numista.model.Coin;
import com.barlo.numista.model.Collection;
import com.barlo.numista.service.NumistaService;
import com.barlo.numista.utils.WindowUtils;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PreDestroy;

public class CoinViewController {

    private static Stage thisStage;

    @Autowired
    @Qualifier("collectionService")
    private NumistaService collectionService;

    @Autowired
    @Qualifier("coinEdit")
    private NumistaConfiguration.ViewHolder coinEdit;

    @Autowired
    private CoinEditController coinEditController;

    @Autowired
    private Coin editingCoin;

    @FXML private Text coinNameText;
    @FXML private Text collectionText;
    @FXML private Text subcollectionText;
    @FXML private Text yearText;
    @FXML private Text countryText;
    @FXML private Text descriptionText;

    public void init(final Stage thisStage) {
        CoinViewController.thisStage = thisStage;

        if (editingCoin.getCoinCollection().getParentId() == null) {
            collectionText.setText((editingCoin.getCoinCollection().getName()));
        }

        if (editingCoin.getCoinCollection().getParentId() != null) {
            subcollectionText.setText(editingCoin.getCoinCollection().getName());

            Collection collection = (Collection) collectionService.findById(editingCoin.getCoinCollection().getParentId());
            collectionText.setText(collection.getName());
        }

        coinNameText.setText(editingCoin.getCoin());
        yearText.setText(editingCoin.getYear());
        countryText.setText(editingCoin.getCountry());
        descriptionText.setText(editingCoin.getDescription());

    }

    public void editCoin() {
        coinEditController.init(thisStage);
        WindowUtils.changeScene(coinEdit, thisStage);
    }
}
