package com.lexyn.pixeldesign.launch;

import com.lexyn.pixeldesign.stages.ApplicationStage;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launch extends Application {

    @Override
    public void start(Stage primary_stage){
        new ApplicationStage().launchAppStage(primary_stage);
    }


}
