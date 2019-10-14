package com.lexyn.pixeldesign.controller;

import com.lexyn.pixeldesign.coord.PixelCoordinate;
import com.lexyn.pixeldesign.logic.ParticleSystem;
import com.lexyn.pixeldesign.logic.PixelMap;
import com.lexyn.pixeldesign.manager.ParticleSystemManager;
import com.lexyn.pixeldesign.render.PixelRenderer;
import com.lexyn.pixeldesign.render.Renderer;
import com.lexyn.pixeldesign.render.transformation.TransformationMatrix;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TitledPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller for the main Window ui logic
 * @author lexyna
 */
public class MainController implements Initializable {

    private static Logger logger = Logger.getLogger(MainController.class.getName());

    @FXML
    private Canvas fx_canvas;
    @FXML
    private TitledPane fx_canvasFrame;

    public MainController(){
        logger.log( Level.INFO,"Initialise Controller");
    }

    @Override
    public void initialize(URL location, ResourceBundle bundle){
        logger.log(Level.INFO, "Setup canvas");

        fx_canvas.widthProperty().bind(fx_canvasFrame.widthProperty());
        fx_canvas.heightProperty().bind(fx_canvasFrame.heightProperty().add(-10));

        fx_canvas.setOnMouseMoved((evt)->{
            PixelCoordinate cord = TransformationMatrix.getInstance().converToPixelCord(evt.getX(), evt.getY());
            ParticleSystemManager.getInstance().getActiveSystem().getPixelRenderer().highlightPixel(cord);
            if(cord.isValid())
                fx_canvasFrame.setText("Filename + Mouse at " + cord.getX() + "/" + cord.getY());

        });

        fx_canvasFrame.widthProperty().addListener(e -> ParticleSystemManager.getInstance().getActiveSystem().getRenderer().resize());
        fx_canvasFrame.heightProperty().addListener(e -> ParticleSystemManager.getInstance().getActiveSystem().getRenderer().resize());

        ParticleSystem particleSystem = new ParticleSystem(new Renderer(fx_canvas), new PixelRenderer(fx_canvas), new PixelMap(64,64, Color.web("666666", 1.0)));
        ParticleSystemManager.getInstance().addSystem(particleSystem);

    }

}
