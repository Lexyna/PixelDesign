package com.lexyn.pixeldesign.fx.controller;

import com.lexyn.pixeldesign.coord.PixelCoordinate;
import com.lexyn.pixeldesign.fx.cellfactory.EmitterListCell;
import com.lexyn.pixeldesign.logic.ParticleSystem;
import com.lexyn.pixeldesign.logic.PixelMap;
import com.lexyn.pixeldesign.logic.emitter.Emitter;
import com.lexyn.pixeldesign.manager.ParticleSystemManager;
import com.lexyn.pixeldesign.render.PixelRenderer;
import com.lexyn.pixeldesign.render.Renderer;
import com.lexyn.pixeldesign.render.transformation.TransformationMatrix;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
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
    @FXML
    private ListView<Emitter> fx_emitterĹist;
    @FXML
    private ScrollPane fx_propertyPane;

    //Menu Context
    @FXML
    private MenuItem fx_newEmitter, fx_deleteEmitter;

    public MainController(){
        logger.log( Level.INFO,"Initialise Controller");
    }

    @Override
    public void initialize(URL location, ResourceBundle bundle){
        logger.log(Level.INFO, "Setup canvas");

        fx_canvas.widthProperty().bind(fx_canvasFrame.widthProperty());
        fx_canvas.heightProperty().bind(fx_canvasFrame.heightProperty().add(-10));

        fx_canvasFrame.widthProperty().addListener(e -> ParticleSystemManager.getInstance().getActiveSystem().getRenderer().resize());
        fx_canvasFrame.heightProperty().addListener(e -> ParticleSystemManager.getInstance().getActiveSystem().getRenderer().resize());

        addCanvasListener(fx_canvas);
        setCellFactories(fx_emitterĹist);
        setSelectionListener(fx_emitterĹist);
        addMenuListener(fx_newEmitter, fx_deleteEmitter);

        ParticleSystem particleSystem = new ParticleSystem(new Renderer(fx_canvas), new PixelRenderer(fx_canvas), new PixelMap(64,64, Color.web("666666", 1.0)));
        ParticleSystemManager.getInstance().addSystem(particleSystem);

        fx_emitterĹist.setItems(ParticleSystemManager.getInstance().getActiveSystem().getPixelMap().getEmitters());

    }

    private void addMenuListener(MenuItem fx_newEmitter, MenuItem fx_deleteEmitter){
        fx_newEmitter.setOnAction(e -> {
            Emitter emitter = new Emitter("Emitter");
            emitter.setProperty(fx_propertyPane);
            fx_emitterĹist.getItems().add(emitter);
        });
        fx_deleteEmitter.setOnAction(e -> {
            if (fx_emitterĹist.getSelectionModel().getSelectedIndex() >= 0)
                fx_emitterĹist.getItems().remove(fx_emitterĹist.getSelectionModel().getSelectedIndex());
            if(fx_emitterĹist.getItems().size() == 0)
                fx_propertyPane.setContent(null);
        });
    }

    private void addCanvasListener(Canvas fx_canvas){
        fx_canvas.setOnMouseMoved((evt)->{
            PixelCoordinate cord = TransformationMatrix.getInstance().converToPixelCord(evt.getX(), evt.getY());
            ParticleSystemManager.getInstance().getActiveSystem().getPixelRenderer().highlightPixel(cord);
            if(cord.isValid())
                fx_canvasFrame.setText("Filename + Mouse at " + cord.getX() + "/" + cord.getY());

        });
    }

    private void setSelectionListener(ListView<Emitter> fx_emitterĹist){
        fx_emitterĹist.getSelectionModel().selectedIndexProperty().addListener(e -> {
            if(fx_emitterĹist.getSelectionModel().getSelectedItem() != null)
                fx_emitterĹist.getSelectionModel().getSelectedItem().setProperty(fx_propertyPane);
        });
    }

    private void setCellFactories(ListView<Emitter> fx_emitterĹist){
        fx_emitterĹist.setCellFactory(list -> new EmitterListCell());
    }

}
