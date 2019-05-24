package com.barlo.numista.utils;

import com.barlo.numista.Numista;
import com.barlo.numista.exception.AbstractNumistaException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class WindowUtils {

    //Create new Window for different purposes
    public static Stage newPopupWindow(final String fxml){

        InputStream fxmlStream;
        Stage thisWindowStage;

        try {
            fxmlStream = WindowUtils.class.getClassLoader().getResourceAsStream(fxml);
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.load(fxmlStream);
            thisWindowStage = newWindow(fxmlLoader);
            return thisWindowStage;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    //Create alert if Exception occurred
    public static void showAlert(final AbstractNumistaException e) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(e.getException());

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText(e.getMessage());

        alert.showAndWait();
    }

    private static Stage newWindow(final FXMLLoader fxmlLoader) {
        //Set new Stage
        Stage newWindow = new Stage();
        //Set owner for this new window. It makes primary stage unavailable while new window is opened
        newWindow.initModality(Modality.APPLICATION_MODAL);
        newWindow.initOwner(Numista.getPrimaryStage().getScene().getWindow());

        newWindow.setScene(new Scene(fxmlLoader.getRoot()));
        newWindow.show();

        return newWindow;
    }

}
