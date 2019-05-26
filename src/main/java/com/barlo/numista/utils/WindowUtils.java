package com.barlo.numista.utils;

import com.barlo.numista.Numista;
import com.barlo.numista.NumistaConfiguration;
import com.barlo.numista.exception.AbstractNumistaException;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WindowUtils {

    //Create new Window for different purposes
    public static Stage newPopupWindow(final NumistaConfiguration.ViewHolder view){

        //Set new Stage
        Stage newWindow = new Stage();
        //Set owner for this new window. It makes primary stage unavailable while new window is opened
        newWindow.initModality(Modality.APPLICATION_MODAL);
        newWindow.initOwner(Numista.getPrimaryStage().getScene().getWindow());

        newWindow.setScene(new Scene(view.getView()));
        newWindow.show();

        return newWindow;
    }

    //Change scene in existing stage
    public static void changeScene(final NumistaConfiguration.ViewHolder view, final Stage stage) {
        stage.setScene(new Scene(view.getView()));
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

}
