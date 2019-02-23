package com.barlo.numista.view;

import com.barlo.numista.model.Coin;
import com.barlo.numista.model.Collection;
import com.barlo.numista.service.NumistaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.List;

public class NumistaFxmlController {

    //Injecting from Spring
    @Autowired
    @Qualifier("coinService")
    private NumistaService coinService;

    @Autowired
    @Qualifier("collectionService")
    private NumistaService collectionService;

    //Injecting from FXML
    @FXML private TableView<Coin> coinTable;
    @FXML private TextField fieldSubcollection;
    @FXML private TextField fieldCoin;
    @FXML private TextField fieldYear;
    @FXML private TextField fieldCountry;
    @FXML private  TextField fieldDescription;
    @FXML private TextField fieldCollectionName;
    @FXML private TableColumn<Coin, String> collectionColumn;
    @FXML private TableColumn<Coin, String> subcollectionColumn;
    @FXML private TableColumn<Coin, String> coinColumn;
    @FXML private TableColumn<Coin, String> yearColumn;
    @FXML private TableColumn<Coin, String> countryColumn;
    @FXML private TableColumn<Coin, String> descriptionColumn;
    @FXML private ComboBox<Collection> collectionComboBox;

    //List that track's changes for TableView
    private ObservableList<Coin> coinData;
    private ObservableList<Collection> collectionData;


    @PostConstruct
    public void init(){

        /*
            First of all we need to fill Table with data from repository.
            Due to this task we use ObservableList. It allows to track changes and add data to table immediately.

            coinList get's all Coins from repository by CoinService.
            Then data converts to ObservableList.

            Value Factories for TableColumns. It's important that parameter be exactly as get method signature e.g. "getCoin()"

            The same thing for ComBox using ObservableList.
         */
        List<Coin> coinList = coinService.findAll();
        coinData = FXCollections.observableArrayList(coinList);

        //Table columns
        collectionColumn.setCellValueFactory(new PropertyValueFactory<>("collection"));
        subcollectionColumn.setCellValueFactory(new PropertyValueFactory<>("subcollection"));
        coinColumn.setCellValueFactory(new PropertyValueFactory<>("coin"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        coinTable.setItems(coinData);

        List<Collection> collectionList = collectionService.findAll();
        collectionData = FXCollections.observableArrayList(collectionList);

        collectionComboBox.setItems(collectionData);

    }

    @FXML
    //Add new coin to repository
    public void addCoin() {

        //Get data from TextField's
        String coin = fieldCoin.getText();
        String year = fieldYear.getText();
        String country = fieldCountry.getText();
        String description = fieldDescription.getText();

        //Check that not nullable fields is not empty
        if (StringUtils.isEmpty(coin)) {
            return;
        }

        //Create new Coin. Then Save it to repository and add it to ObservableList
        //ObservableList allows to track changes. So, it allows to immediately add changes to table
        Coin newCoin = new Coin(coin, year, country, description);
        coinService.save(newCoin);
        coinData.add(newCoin);

        //Clear fields
        fieldSubcollection.setText("");
        fieldCoin.setText("");
        fieldYear.setText("");
        fieldCountry.setText("");
        fieldDescription.setText("");


    }

    @FXML
    //Create new collection in repository
    public  void newCollection() {

        //Get data of new Collection Name
        String newCollectionName = fieldCollectionName.getText();

        //Check that data is not empty
        if (StringUtils.isEmpty(newCollectionName)) {
            return;
        }

        //Create new instance of Collection
        Collection newCollection = new Collection(newCollectionName);

        //Add Collection to repository and ObservableList of ComboBox
        collectionData.add(newCollection);
        collectionService.save(newCollection);

        //Clear field
        fieldCollectionName.setText("");

    }

}
