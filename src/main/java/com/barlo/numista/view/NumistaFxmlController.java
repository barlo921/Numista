package com.barlo.numista.view;

import com.barlo.numista.model.Coin;
import com.barlo.numista.service.CoinService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.List;

public class NumistaFxmlController {

    //Injecting from Spring
    @Autowired
    private CoinService coinService;

    //Injecting from FXML
    @FXML
    private TableView<Coin> coinTable;
    @FXML
    private TextField fieldCollection;
    @FXML
    private TextField fieldSubcollection;
    @FXML
    private TextField fieldCoin;
    @FXML
    private TextField fieldYear;
    @FXML
    private TextField fieldCountry;
    @FXML
    private  TextField fieldDescription;
    @FXML
    private TableColumn<Coin, String> idColumn;
    @FXML
    private TableColumn<Coin, String> collectionColumn;
    @FXML
    private TableColumn<Coin, String> subcollectionColumn;
    @FXML
    private TableColumn<Coin, String> coinColumn;
    @FXML
    private TableColumn<Coin, String> yearColumn;
    @FXML
    private TableColumn<Coin, String> countryColumn;
    @FXML
    private TableColumn<Coin, String> descriptionColumn;

    //List that track's changes for TableView
    private ObservableList<Coin> data;


    @PostConstruct
    public void init(){

        List<Coin> coinList = coinService.findAll();
        data = FXCollections.observableArrayList(coinList);

        //Table columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        collectionColumn.setCellValueFactory(new PropertyValueFactory<>("collection"));
        subcollectionColumn.setCellValueFactory(new PropertyValueFactory<>("subcollection"));
        coinColumn.setCellValueFactory(new PropertyValueFactory<>("coin"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        coinTable.setItems(data);
    }

    @FXML
    public void addCoin() {

        String collection = fieldCollection.getText();
        String subcollection = fieldSubcollection.getText();
        String coin = fieldCoin.getText();
        String year = fieldYear.getText();
        String country = fieldCountry.getText();
        String description = fieldDescription.getText();

        if (StringUtils.isEmpty(collection) || StringUtils.isEmpty(coin)) {
            return;
        }

        Coin newCoin = new Coin(collection, subcollection, coin, year, country, description);
        coinService.save(newCoin);
        data.add(newCoin);

        fieldCollection.setText("");
        fieldSubcollection.setText("");
        fieldCoin.setText("");
        fieldYear.setText("");
        fieldCountry.setText("");
        fieldDescription.setText("");


    }

}
