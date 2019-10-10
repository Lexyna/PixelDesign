package com.lexyn.pixeldesign.stages;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationStage {

    private static Logger logger = Logger.getLogger(ApplicationStage.class.getName());

    private Stage appStage;
    private Scene scene;
    private Parent parent;

    public ApplicationStage() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/appStage.fxml"));

        try {
            Parent root = loader.load();
            scene = new Scene(root, 700, 400);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, ex.toString(), ex);
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