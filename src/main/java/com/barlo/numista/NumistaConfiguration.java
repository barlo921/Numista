package com.barlo.numista;

import com.barlo.numista.model.Coin;
import com.barlo.numista.view.CoinEditController;
import com.barlo.numista.view.CoinViewController;
import com.barlo.numista.view.NumistaFxmlController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class NumistaConfiguration {

    @Bean(name = "mainView")
    public ViewHolder getMainView() throws IOException{
        return loadView("fxml/main.fxml");
    }

    @Bean(name = "coinView")
    public ViewHolder getCoinView() throws IOException{
        return loadView("fxml/coinTemplateFXML.fxml");
    }

    @Bean(name = "coinEdit")
    public ViewHolder getCoinEdit() throws IOException{
        return loadView("fxml/coinUpdateTemplateFXML.fxml");
    }

    //This method adds FXML Controller (NumistaFxmlController) to spring context
    @Bean
    public NumistaFxmlController getNumistaFxmlController() throws IOException {
        return (NumistaFxmlController) getMainView().getController();
    }

    @Bean
    public CoinViewController getCoinViewController() throws IOException {
        return (CoinViewController) getCoinView().getController();
    }

    @Bean
    public CoinEditController getCoinEditController() throws IOException{
        return (CoinEditController) getCoinEdit().getController();
    }

    @Bean
    public Coin getEditingCoin(){
        return new Coin();
    }

    @Bean
    public Scene getScenePopupWindows() throws IOException {
        return new Scene(loadView("fxml/main.fxml").getView());
    }

    //loadView method loads FXML UI from specified file
    private ViewHolder loadView(final String fxmlUrl) throws IOException {

        InputStream fxmlStream = null;

        try {
            fxmlStream = getClass().getClassLoader().getResourceAsStream(fxmlUrl);
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.load(fxmlStream);
            return new ViewHolder(fxmlLoader.getRoot(), fxmlLoader.getController());
        } finally {
            if (fxmlStream != null)
                fxmlStream.close();
        }

    }


    //ViewHolder is inner class to store view and controller of Numista application
    public class ViewHolder {

        private Parent view;
        private Object controller;

        public ViewHolder(Parent view, Object controller) {
            this.view = view;
            this.controller = controller;
        }

        public Parent getView() {
            return view;
        }

        public void setView(Parent view) {
            this.view = view;
        }

        public Object getController() {
            return controller;
        }

        public void setController(Object controller) {
            this.controller = controller;
        }
    }

}
