package com.lexyn.pixeldesign.logic.emitter;

import com.lexyn.pixeldesign.color.PixelColor;
import com.lexyn.pixeldesign.fx.controller.PropertyController;
import com.lexyn.pixeldesign.manager.ParticleSystemManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

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

    private int coordX, coordY;

    private int spawnRateMin = 1, spawnRateMax = 1;
    private int spawnRadiusMin = 1, spawnRadiusMax = 1;
    private int spawnIntervallMin = 1, spawnIntervallMax = 1, spawnTick = 1;

    //Particle Properties

    private PixelColor particleColor = new PixelColor(255,255,255, 1);

    private int pSpeedMin = 1, pSpeedMax = 4;
    private int pLifetimeMin = 1, pLifetimeMax = 5;

    public Emitter(){
    }

    public Emitter(String name){
        this.name = name;
        coordY = ParticleSystemManager.getInstance().getActiveSystem().getPixelMap().getMapHeight() / 2;
        coordX = ParticleSystemManager.getInstance().getActiveSystem().getPixelMap().getMapWidth() / 2;
    }

    /**
     *  calculate variable parameters in bound create particles corresponding
     */
    public void tick(){

        this.spawnTick -= 1;

        if(spawnTick == 0){
            spawnTick = (int) Math.floor(spawnIntervallMin + Math.random() * (spawnIntervallMax - spawnIntervallMin));
            createParticle();
        }

    }

    /**
     * Creates a particle with random parameters in bound
     */
    private void createParticle(){

        int rate = (int) Math.floor(spawnRateMin + Math.random() * (spawnRateMax - spawnRateMin));

        for(int i = 0; i < rate; i++){

            int posX = createRandomInt(spawnRadiusMin, spawnRadiusMax);
            int posY = createRandomInt(spawnRadiusMin, spawnRadiusMax);

            posX = randomInvert(posX);
            posY = randomInvert(posY);

            int speedX = createRandomInt(pSpeedMin, pSpeedMax);
            int speedY = createRandomInt(pSpeedMin, pSpeedMax);

            speedX = randomInvert(speedX);
            speedY = randomInvert(speedY);

            int lifetime = createRandomInt(pLifetimeMin, pLifetimeMax);

            posX += this.coordX;
            posY += this.coordY;

            ParticleSystemManager.getInstance().getActiveSystem().getPixelMap().addParticle(
                    new Particle(posX, posY, lifetime, speedX, speedY, particleColor)
            );

        }

    }

    private int randomInvert(int randomInvert){
        if(Math.random() > 0.5)
            randomInvert *= -1;
        return randomInvert;
    }

    private int createRandomInt(int min, int max){
        return (int) Math.floor(min + Math.random() * (max-min));
    }

    public void setProperty(ScrollPane propertyPane){
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

    public void setParticleColor(PixelColor color){
        this.particleColor = color;
    }

    @Override
    public boolean equals(Object o){
        if(o == this)
            return true;

        if(!(o instanceof Emitter))
            return false;

        Emitter copy = (Emitter) o;

        return (this.getName().equals(copy.getName()) &&
                this.coordX == copy.coordX && this.coordY == copy.coordY &&
                this.spawnRadiusMin == copy.spawnRadiusMin && this.spawnRadiusMax == copy.spawnRadiusMax &&
                this.spawnRateMin == copy.spawnRateMin && this.spawnRateMax == copy.spawnRateMax &&
                this.spawnIntervallMin == copy.spawnIntervallMin && this.spawnIntervallMax == copy.spawnIntervallMax);
    }
}
