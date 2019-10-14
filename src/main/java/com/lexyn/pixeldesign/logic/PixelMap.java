package com.lexyn.pixeldesign.logic;

import javafx.scene.paint.Color;

/**
 * Handle all events and metadata on the pixel map
 * @author lexyna
 */
public class PixelMap {

    private int mapWidth, mapHeight;
    private Color backgroundColor;

    public PixelMap(int mapWidth, int mapHeight, Color color){
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.backgroundColor = color;
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

}
