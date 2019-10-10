package com.lexyn.pixeldesign.render.transformation;

import com.lexyn.pixeldesign.logic.PixelMap;

/**
 * Transforms pixle coordinates to rts coordinates
 * and rts to pixel coordinates
 * @author lexyna
 */
public class TransformationMatrix {

    private static TransformationMatrix matrix;

    public static TransformationMatrix getInstance(){
        if(matrix == null)
            matrix = new TransformationMatrix();
        return matrix;
    }

    private double pixelWdith, pixelHeight;

    /**
     * Takes the width and height of the canvas and desired PixelMap
     * and calculates the pixel dimensions
     */
    public void calculatePixel(double canvasWidth, double canvasHeight){
        this.pixelWdith = canvasWidth / PixelMap.getInstance().getMapWidth();
        this.pixelHeight = canvasHeight / PixelMap.getInstance().getMapHeight();
    }

    public double getPixelWdith(){
        return pixelWdith;
    }

    public double getPixelHeight(){
        return pixelHeight;
    }

}
