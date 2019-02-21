package com.barlo.numista;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Numista extends AbstractNumistaApplication {

    @Value("${ui.title}")
    private String windowTitle;

    //Spring gets Bean named "mainView" from context and assign it to view field
    @Qualifier("mainView")
    @Autowired
    NumistaConfiguration.ViewHolder view;

    @Override
    public void start(Stage primaryStage) throws Exception {

        //JavaFX setting stage and show UI
        primaryStage.setTitle(windowTitle);
        primaryStage.setScene(new Scene(view.getView()));
        primaryStage.setResizable(true);
        primaryStage.centerOnScreen();
        primaryStage.show();

    }

    public static void main(String[] args) {
        lunchApp(Numista.class, args);
    }
}
