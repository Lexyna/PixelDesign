package com.lexyn.pixeldesign.stages;
import com.lexyn.pixeldesign.render.Renderer;
import com.lexyn.pixeldesign.render.transformation.TransformationMatrix;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainStage {

    private static Logger logger = Logger.getLogger(MainStage.class.getName());

    private Stage mainStage;
    private Scene scene;
    private Parent parent;

    public MainStage() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/appStage.fxml"));

        try {
            Parent root = loader.load();
            scene = new Scene(root, 750, 440);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, ex.toString(), ex);
            System.exit(1);
        }
    }

    public void launchAppStage(Stage appStage) {
        this.mainStage = appStage;

        appStage.setScene(scene);
        appStage.setTitle("PixelDesign");
        appStage.setResizable(true);

        mainStage.widthProperty().addListener((obs, oldValue, newValue) -> {
            Renderer.getInstance().resize();
        });

        mainStage.heightProperty().addListener((obs, oldValue, newValue) -> {
            Renderer.getInstance().resize();
        });

        appStage.setMinHeight(420);
        appStage.setMinWidth(720);

        appStage.show();
    }

}