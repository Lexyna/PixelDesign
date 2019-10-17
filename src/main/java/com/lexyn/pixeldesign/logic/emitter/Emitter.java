package com.lexyn.pixeldesign.logic.emitter;

import com.lexyn.pixeldesign.fx.controller.PropertyController;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.io.Serializable;

/**
 * the main source of particle effect, store and calculated all data relevant for
 * particles to render
 * @author lexyna
 */
public class Emitter implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private AnchorPane propertyNode;

    //Emitter properties

    private DoubleProperty coordX = new SimpleDoubleProperty(0), coordY = new SimpleDoubleProperty(0);

    private DoubleProperty spawnRateMin = new SimpleDoubleProperty(0), spawnRateMax = new SimpleDoubleProperty(0);
    private DoubleProperty spawnRadiusMin = new SimpleDoubleProperty(0), spawnRadiusMax = new SimpleDoubleProperty(0);
    private DoubleProperty spawnIntervallMin = new SimpleDoubleProperty(0), spawnIntervallMax = new SimpleDoubleProperty(0);

    //Particle Properties

    private Color particleColor;

    public Emitter(){}

    public Emitter(String name){
        this.name = name;
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/propertyStage.fxml"));
            propertyNode = loader.load();
            PropertyController pc = loader.getController();
            pc.bindParamsToEmitter(this);
        }catch (IOException ex){

        }
    }

    public void setProperty(ScrollPane propertyPane){
        propertyPane.setContent(propertyNode);
        propertyNode.prefWidthProperty().bind(propertyPane.widthProperty());
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setParticleColor(Color color){
        this.particleColor = color;
    }

    public DoubleProperty coordX(){
        return coordX;
    }

    public DoubleProperty coordY(){
        return coordY;
    }

    public DoubleProperty spawnRateMinProperty() {
        return spawnRateMin;
    }

    public DoubleProperty spawnRateMaxProperty() {
        return spawnRateMax;
    }

    public DoubleProperty spawnRadiusMinProperty() {
        return spawnRadiusMin;
    }

    public DoubleProperty spawnRadiusMaxProperty() {
        return spawnRadiusMax;
    }


    public DoubleProperty spawnIntervallMinProperty() {
        return spawnIntervallMin;
    }

    public DoubleProperty spawnIntervallMaxProperty() {
        return spawnIntervallMax;
    }

    @Override
    public boolean equals(Object o){
        if(o == this)
            return true;

        if(!(o instanceof Emitter))
            return false;

        Emitter copy = (Emitter) o;

        return this.getName().equals(copy.getName());
    }
}
