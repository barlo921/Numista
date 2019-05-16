package com.barlo.numista;

import com.barlo.numista.view.NumistaFxmlController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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

    //This method adds FXML Controller (NumistaFxmlController) to spring context
    @Bean
    public NumistaFxmlController getNumistaFxmlController() throws IOException {
        return (NumistaFxmlController) getMainView().getController();
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
