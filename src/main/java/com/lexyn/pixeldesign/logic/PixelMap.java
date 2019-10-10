package com.lexyn.pixeldesign.logic;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

/**
 * Handle all events and metadata on the pixel map
 * @author lexyna
 */
public class PixelMap {

    private static PixelMap pixelMap;

    public static PixelMap getInstance(){
        if(pixelMap == null)
            pixelMap =  new PixelMap();
        return pixelMap;
    }

    private int mapWidth, mapHeight;
    private Color backgroundColor;

    private PixelMap(){
        this.mapWidth = 16;
        this.mapHeight = 16;
        this.backgroundColor = Color.web("#666666", 1.0);
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
