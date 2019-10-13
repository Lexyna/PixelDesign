package com.lexyn.pixeldesign.controller;

import com.lexyn.pixeldesign.coord.PixelCoordinate;
import com.lexyn.pixeldesign.render.PixelRenderer;
import com.lexyn.pixeldesign.render.Renderer;
import com.lexyn.pixeldesign.render.transformation.TransformationMatrix;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TitledPane;

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
        System.out.println("Initialise Controller");
    }

    @Override
    public void initialize(URL location, ResourceBundle bundle){
        logger.log(Level.INFO, "Setup canvas");

        fx_canvas.widthProperty().bind(fx_canvasFrame.widthProperty());
        fx_canvas.heightProperty().bind(fx_canvasFrame.heightProperty().add(-10));

        fx_canvas.setOnMouseMoved((evt)->{
            PixelCoordinate cord = TransformationMatrix.getInstance().converToPixelCord(evt.getX(), evt.getY());
            PixelRenderer.getInstance().highlightPixel(cord);
            if(cord.isValid())
                fx_canvasFrame.setText("Filename + Mouse at " + cord.getX() + "/" + cord.getY());

        });

        fx_canvasFrame.widthProperty().addListener(e -> Renderer.getInstance().resize());

        Renderer.getInstance().setCanvas(fx_canvas);
        PixelRenderer.getInstance().setCanvas(fx_canvas);

    }

}
