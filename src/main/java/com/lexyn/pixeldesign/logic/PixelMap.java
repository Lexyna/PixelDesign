package com.lexyn.pixeldesign.logic;

import com.lexyn.pixeldesign.logic.emitter.Emitter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

/**
 * Handle all events and metadata on the pixel map
 * @author lexyna
 */
public class PixelMap {

    private int mapWidth, mapHeight;
    private Color backgroundColor;

    private ObservableList<Emitter> emitters;

    public PixelMap(int mapWidth, int mapHeight, Color color){
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.backgroundColor = color;
        emitters = FXCollections.observableArrayList();
    }

    public int getMapWidth(){
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public ObservableList getEmitters(){ return emitters;}

}
