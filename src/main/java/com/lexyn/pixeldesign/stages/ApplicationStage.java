package com.lexyn.pixeldesign.stages;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationStage {

    private Stage appStage;
    private Scene scene;
    private Parent parent;

    public ApplicationStage() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/appStage.fxml"));

        try {
            Parent root = loader.load();
            scene = new Scene(root, 700, 400);
        } catch (IOException ex) {
            //TODO: -> LOGGER
            System.out.println("Alert doesnt work --issue at github");
            ex.printStackTrace();
            System.exit(1);
        }
    }

    public void launchAppStage(Stage appStage) {
        this.appStage = appStage;

        appStage.setScene(scene);
        appStage.setTitle("PixelDesign");
        appStage.setResizable(true);


        appStage.setMinHeight(400);
        appStage.setMinWidth(700);

        appStage.show();
    }

}