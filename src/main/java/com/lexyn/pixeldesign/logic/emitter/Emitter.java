package com.lexyn.pixeldesign.logic.emitter;

import com.lexyn.pixeldesign.fx.controller.PropertyController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.*;

/**
 * the main source of particle effect, store and calculated all data relevant for
 * particles to render
 * @author lexyna
 */
public class Emitter implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    //Emitter properties

    private int coordX = 0, coordY = 0;

    private int spawnRateMin = 0, spawnRateMax = 0;
    private int spawnRadiusMin = 0, spawnRadiusMax = 0;
    private int spawnIntervallMin = 0, spawnIntervallMax = 0;

    //Particle Properties

    private transient Color particleColor;

    public Emitter(){}

    public Emitter(String name){
        this.name = name;

    }

   public void setProperty(ScrollPane propertyPane){
        System.out.println("set prop");
       try {
           FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/propertyStage.fxml"));
           AnchorPane propertyNode = loader.load();
           PropertyController pc = loader.getController();
           pc.bindParamsToEmitter(this);
           pc.setParams(coordX, coordY,
                   spawnRadiusMin, spawnRadiusMax,
                   spawnRateMin, spawnRateMax,
                   spawnIntervallMin, spawnIntervallMax,
                   particleColor);
           propertyPane.setContent(propertyNode);
           propertyNode.prefWidthProperty().bind(propertyPane.widthProperty());
       }catch (IOException ex){

       }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public void setSpawnRateMin(int spawnRateMin) {
        this.spawnRateMin = spawnRateMin;
    }

    public void setSpawnRateMax(int spawnRateMax) {
        this.spawnRateMax = spawnRateMax;
    }

    public void setSpawnRadiusMin(int spawnRadiusMin) {
        this.spawnRadiusMin = spawnRadiusMin;
    }

    public void setSpawnRadiusMax(int spawnRadiusMax) {
        this.spawnRadiusMax = spawnRadiusMax;
    }

    public void setSpawnIntervallMin(int spawnIntervallMin) {
        this.spawnIntervallMin = spawnIntervallMin;
    }

    public void setSpawnIntervallMax(int spawnIntervallMax) {
        this.spawnIntervallMax = spawnIntervallMax;
    }

    public void setParticleColor(Color color){
        this.particleColor = color;
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
