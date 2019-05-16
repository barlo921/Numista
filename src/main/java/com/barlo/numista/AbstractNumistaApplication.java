package com.barlo.numista;


import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

//This class initialize Spring Context during JavaFX initialization
public abstract class AbstractNumistaApplication extends Application {

    private static String [] savedArgs;
    protected ConfigurableApplicationContext context;

    @Override
    public void init() throws Exception {
        context = SpringApplication.run(getClass(), savedArgs); //Spring Context initialize
        context.getAutowireCapableBeanFactory().autowireBean(this); //Fill context with Beans
    }

    @Override
    public void stop() throws Exception{
        super.stop();
        context.close();
    }

    protected static void lunchApp(final Class <? extends AbstractNumistaApplication> app, final String [] args){
        savedArgs = args;
        Application.launch(app, args);
    }

}
