package com.lexyn.pixeldesign.launch;

import com.lexyn.pixeldesign.stages.AppStage;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Launch extends Application {

    private static Logger LOGGER = Logger.getLogger(Application.class.getName());
    private FileHandler log;

    @Override
    public void start(Stage primary_stage){

        try{
            log = new FileHandler("Pixellog.log", false);
        }catch (SecurityException | IOException ex){
            ex.printStackTrace();
        }

        Logger l = Logger.getLogger("");
        log.setFormatter(new SimpleFormatter());
        l.addHandler(log);

        new AppStage().launchAppStage(primary_stage);

    }


}
