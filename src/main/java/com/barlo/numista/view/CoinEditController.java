package com.barlo.numista.view;

import com.barlo.numista.model.Coin;
import com.barlo.numista.model.Collection;
import com.barlo.numista.service.NumistaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import java.util.List;

public class CoinEditController {

    private static Stage thisStage;
    private static NumistaFxmlController.CoinData coinData;

    @Autowired
    @Qualifier("collectionService")
    private NumistaService collectionService;

    @Autowired
    @Qualifier("coinService")
    private NumistaService coinService;

    @FXML private TextField coinNameField;
    @FXML private ComboBox<Collection> collectionComboBox;
    @FXML private ComboBox<Collection> subcollectionComboBox;
    @FXML private TextField yearField;
    @FXML private TextField countryField;
    @FXML private TextField descriptionField;

    private ObservableList<Collection> collectionData;
    private ObservableList<Collection> subcollectionData;

    private Coin editingCoin;

    @PostConstruct
    public void init(){

    }

    public void saveCoin(){

    }

    public void browseImage(){

    }

}
