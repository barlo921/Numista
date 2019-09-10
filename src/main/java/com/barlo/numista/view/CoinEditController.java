package com.barlo.numista.view;

import com.barlo.numista.NumistaConfiguration;
import com.barlo.numista.model.Coin;
import com.barlo.numista.model.Collection;
import com.barlo.numista.service.CoinService;
import com.barlo.numista.service.CollectionService;
import com.barlo.numista.utils.CollectionUtil;
import com.barlo.numista.utils.WindowUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collections;
import java.util.List;

public class CoinEditController {

    private static Stage thisStage;

    @Autowired
    private CollectionService collectionService;
    @Autowired
    private CoinService coinService;
    @Autowired
    private CoinViewController coinViewController;
    @Autowired
    @Qualifier("coinView")
    private NumistaConfiguration.ViewHolder coinView;
    @Autowired
    private CollectionUtil collectionUtil;

    @FXML private TextField coinNameField;
    @FXML private ChoiceBox<Collection> collectionChoiceBox;
    @FXML private ChoiceBox<Collection> subcollectionChoiceBox;
    @FXML private TextField yearField;
    @FXML private TextField countryField;
    @FXML private TextField descriptionField;
    @FXML private Button saveButton;

    private ObservableList<Collection> collectionData;
    private ObservableList<Collection> subcollectionData;

    @Autowired
    private Coin editingCoin;

    public void init(Stage thisStage){
        CoinEditController.thisStage = thisStage;

        coinNameField.setText(editingCoin.getName());

        collectionData = collectionUtil.getAllTopLevel();
        collectionChoiceBox.setItems(collectionData);

        subcollectionData = FXCollections.observableArrayList(Collections.EMPTY_LIST);
        subcollectionChoiceBox.setItems(subcollectionData);

        yearField.setText(editingCoin.getYear());
        countryField.setText(editingCoin.getCountry());
        descriptionField.setText(editingCoin.getDescription());

    }

    @FXML
    public void saveCoin(){
        editingCoin.setName(coinNameField.getText());

        int collectionId;

        if (subcollectionChoiceBox.getValue() != null) {
            collectionId = subcollectionChoiceBox.getValue().getId();
        } else {
            collectionId = collectionChoiceBox.getValue().getId();
        }

        editingCoin.setYear(yearField.getText());
        editingCoin.setCountry(countryField.getText());
        editingCoin.setDescription(descriptionField.getText());

        coinService.update(editingCoin, collectionId);

        WindowUtils.changeScene(coinView, thisStage);
    }

    @FXML
    public void subcollectionFilter() {
        subcollectionData.clear();
        subcollectionData.setAll(collectionUtil.getSubLevel(collectionChoiceBox.getValue().getId()));
    }

    public void browseImage(){

    }

}
