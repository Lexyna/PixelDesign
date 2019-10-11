package com.lexyn.pixeldesign.controller;

import com.lexyn.pixeldesign.render.PixelRenderer;
import com.lexyn.pixeldesign.render.Renderer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;

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
    AnchorPane root;
    @FXML
    private Canvas canvas;
    @FXML
    private TitledPane canvas_frame;

    public MainController(){
        System.out.println("Initialise Controller");
    }

    @Override
    public void initialize(URL location, ResourceBundle bundle){
        logger.log(Level.INFO, "Setup canvas");

        canvas.widthProperty().bind(canvas_frame.widthProperty());
        canvas.heightProperty().bind(canvas_frame.heightProperty().add(-10));

        Renderer.getInstance().setCanvas(canvas);
        PixelRenderer.getInstance().setCanvas(canvas);
    }



}
