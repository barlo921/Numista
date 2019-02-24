package com.barlo.numista.view;

import com.barlo.numista.exception.*;
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
import org.springframework.dao.DataIntegrityViolationException;
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
    @FXML private TextField fieldCoin;
    @FXML private TextField fieldYear;
    @FXML private TextField fieldCountry;
    @FXML private TextField fieldDescription;
    @FXML private TextField fieldCollectionName;
    @FXML private TableColumn<Coin, String> collectionColumn;
    @FXML private TableColumn<Coin, String> subcollectionColumn;
    @FXML private TableColumn<Coin, String> coinColumn;
    @FXML private TableColumn<Coin, String> yearColumn;
    @FXML private TableColumn<Coin, String> countryColumn;
    @FXML private TableColumn<Coin, String> descriptionColumn;
    @FXML private ComboBox<Collection> collectionComboBox;
    @FXML private ComboBox<Collection> subcollectionComboBox;
    @FXML private ChoiceBox<Collection> collectionToSubcollectionSelector;
    @FXML private CheckBox subcollectionCheckBox;
    @FXML private Button addCoinButton;

    //List that track's changes for TableView
    private ObservableList<Coin> coinData;
    private ObservableList<Collection> collectionData;
    private ObservableList<Collection> subcollectionData;


    @PostConstruct
    public void init(){

        /*
            First of all we need to fill Table with data from repository.
            Due to this task we use ObservableList. It allows to track changes and add data to table immediately.

            coinList get's all Coins from repository by CoinService.
            Then data converts to ObservableList.

            Value Factories for TableColumns. It's important that parameter be exactly as get method signature e.g. "getCoin()"

            The same thing for ComBox (Collections List when adding coins) and
            ChoiceBox (Collection List when create new subcollection) using ObservableList.
            For both options used the same ObservableList.
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

        /*
            ObservableList collectionData is filled only with top-level collections.
            Subcollections were removed before adding.
        */
        List<Collection> collectionList = collectionService.findAll();
        //Remove all subcollections from list
        collectionList.removeIf(collection -> collection.getParentId() != null);
        collectionData = FXCollections.observableArrayList(collectionList);

        collectionComboBox.setItems(collectionData);
        collectionToSubcollectionSelector.setItems(collectionData);

        collectionList.clear();
        subcollectionData = FXCollections.observableArrayList(collectionList);
        subcollectionComboBox.setItems(subcollectionData);

    }

    @FXML
    //Add new coin to repository
    public void addCoin() {

        //Get data from TextField's
        String coin = fieldCoin.getText();
        String year = fieldYear.getText();
        String country = fieldCountry.getText();
        String description = fieldDescription.getText();

        try {

            //Check that not nullable fields is not empty
            if (StringUtils.isEmpty(coin)) {
                throw new CoinNameIsEmptyException();
            }

            //Create new Coin. Then Save it to repository and add it to ObservableList
            //ObservableList allows to track changes. So, it allows to immediately add changes to table
            Coin newCoin = new Coin(coin, year, country, description);
            coinService.save(newCoin);
            coinData.add(newCoin);

            //Clear fields
            fieldCoin.setText("");
            fieldYear.setText("");
            fieldCountry.setText("");
            fieldDescription.setText("");

        } catch (AbstractNumistaException e) {
            showAlert(e);
        }


    }

    @FXML
    //Create new collection in repository
    public void newCollection() {

        //Get data of new Collection Name
        String newCollectionName = fieldCollectionName.getText();

        //Create new Collection
        Collection newCollection;

        /*
            Check whether Subcollection CheckBox is set.
            If true check top-level collection is chosen or throw Exception.
            Finally if all ok create newCollection that has Name and ParentId which is Id of top-level chosen collection.
            Also show alert if Exception is occurred.
         */
        try {

            //Check that data is not empty
            if (StringUtils.isEmpty(newCollectionName)) {
                throw new CollectionNameIsEmptyException();
            }


            if (subcollectionCheckBox.isSelected()) {

                Collection parentCollection = collectionToSubcollectionSelector.getValue();

                if (parentCollection == null) {
                    throw new CollectionIsNotSetException();
                } else {
                    newCollection = new Collection(newCollectionName, parentCollection.getId());
                    collectionService.save(newCollection);
                    subcollectionData.add(newCollection);
                }

            } else {
                newCollection = new Collection(newCollectionName);

                //Add Collection to repository and ObservableList of ComboBox.
                collectionService.save(newCollection);
                collectionData.add(newCollection);

            }

            //Clear field
            fieldCollectionName.setText("");

        }catch (AbstractNumistaException e) {
            showAlert(e);
        } catch (DataIntegrityViolationException e) {
            showAlert(new CollectionAlreadyExistsException(newCollectionName));
        }

    }

    @FXML
    //If Collection ComboBox become not empty then fields to enter data and submit button become enable.
    public void checkCollectionComboBoxAction() {

        if (collectionComboBox.getValue() != null) {

            subcollectionComboBox.setDisable(false);
            fieldCoin.setDisable(false);
            fieldYear.setDisable(false);
            fieldCountry.setDisable(false);
            fieldDescription.setDisable(false);
            addCoinButton.setDisable(false);

        }

        //Show sub collections specified only for chosen top-level collection
        subcollectionFilter();

    }

    @FXML
    //If Subcollection CheckBox is selected then collection selector become enable.
    public void checkSubcollectionCheckBox() {

        if (subcollectionCheckBox.isSelected()) {
            collectionToSubcollectionSelector.setDisable(false);
        } else {
            collectionToSubcollectionSelector.setDisable(true);
        }

    }

    private void showAlert(final AbstractNumistaException e) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(e.getException());

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText(e.getMessage());

        alert.showAndWait();
    }

    //Subcollection ComboBox must contain only sub collections of specified collection
    private void subcollectionFilter() {

        //First clear ComboBox items to prevent choose sub collection from different top-level collection
        subcollectionComboBox.getItems().clear();

        //Get all collections from repository
        List<Collection> subcollectionList = collectionService.findAll();

        //Get top-level collection specified in ComoBox
        Collection topLevelCollection = collectionComboBox.getValue();

        //Remove all top-level collections
        subcollectionList.removeIf(collection -> collection.getParentId() == null);

        //Remove all sub collections not parented to top-level collection specified in ComboBox
        subcollectionList.removeIf(collection -> collection.getParentId() != topLevelCollection.getId());

        //Add filtered List to ObservableList
        subcollectionData.setAll(subcollectionList);

    }

}
