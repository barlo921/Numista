package com.barlo.numista.view;

import com.barlo.numista.NumistaConfiguration;
import com.barlo.numista.model.Coin;
import com.barlo.numista.model.Collection;
import com.barlo.numista.service.NumistaService;
import com.barlo.numista.utils.WindowUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import java.util.List;

public class CoinEditController {

    private static Stage thisStage;

    @Autowired
    @Qualifier("collectionService")
    private NumistaService collectionService;

    @Autowired
    @Qualifier("coinService")
    private NumistaService coinService;

    @Autowired
    private CoinViewController coinViewController;

    @Autowired
    @Qualifier("coinView")
    private NumistaConfiguration.ViewHolder coinView;

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

        coinNameField.setText(editingCoin.getCoin());

        List<Collection> collectionList = collectionService.findAll();
        //Remove all subcollections from list
        collectionList.removeIf(collection -> collection.getParentId() != null);
        collectionData = FXCollections.observableArrayList(collectionList);

        collectionChoiceBox.setItems(collectionData);

        collectionList.clear();
        collectionList = collectionService.findAll();
        //Remove all collections from list
        collectionList.removeIf(collection -> collection.getParentId() == null);
        subcollectionData = FXCollections.observableArrayList(collectionList);
        subcollectionChoiceBox.setItems(subcollectionData);

        yearField.setText(editingCoin.getYear());
        countryField.setText(editingCoin.getCountry());
        descriptionField.setText(editingCoin.getDescription());

    }

    public void saveCoin(){
        editingCoin.setCoin(coinNameField.getText());

        if (subcollectionChoiceBox.getValue() != null) {
            editingCoin.setCoinCollection(subcollectionChoiceBox.getValue());
        } else {
            editingCoin.setCoinCollection(collectionChoiceBox.getValue());
        }

        editingCoin.setYear(yearField.getText());
        editingCoin.setCountry(countryField.getText());
        editingCoin.setDescription(descriptionField.getText());

        coinService.save(editingCoin);

        WindowUtils.changeScene(coinView, thisStage);
    }

    public void browseImage(){

    }

}
