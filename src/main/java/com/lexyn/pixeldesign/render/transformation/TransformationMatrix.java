package com.lexyn.pixeldesign.render.transformation;

import com.lexyn.pixeldesign.coord.PixelCoordinate;
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


    private int fixedOffset = 10;

    //map offset form canvas to get and even pixel map
    private double offsetX, offsetY;

    //start of pixel map coordinates
    private double pixelStartX, pixelStartY;
    private double pixelEndX, pixelEndY;

    //pixel map width and height
    private int pixelMapDimension;

    //pixel width and height
    private int pixelDistance;

    public PixelCoordinate converToPixelCord(double mouseX, double mouseY){
        return new PixelCoordinate((int) ((mouseX - TransformationMatrix.getInstance().getPixelStartX())/ TransformationMatrix.getInstance().getPixelDistance()),
                (int) ((mouseY - TransformationMatrix.getInstance().getPixelStartY()) / TransformationMatrix.getInstance().getPixelDistance()));
    }

    /**
     * Takes the width and height of the canvas and desired PixelMap
     * and calculates the pixel dimensions
     */
    public void calculatePixel(double canvasWidth, double canvasHeight){

        //The pixel map dimensions are calculated with the min(canvasWidth, canvasHeight) to create evenly distributed map;
        // => Pixels will not be streched

        //Only one offset will be used
        offsetX = (canvasWidth - fixedOffset) % PixelMap.getInstance().getMapWidth();
        offsetY = (canvasHeight - fixedOffset) % PixelMap.getInstance().getMapHeight();


        pixelMapDimension = (int) Math.min(canvasWidth - fixedOffset - offsetX, canvasHeight -fixedOffset - offsetY);

        pixelDistance = pixelMapDimension / Math.max(PixelMap.getInstance().getMapWidth(), PixelMap.getInstance().getMapHeight());

        pixelStartX = (canvasWidth - pixelMapDimension) / 2;
        pixelStartY = (canvasHeight - pixelMapDimension) / 2;

        pixelEndX = pixelStartX + pixelMapDimension;
        pixelEndY = pixelStartY + pixelMapDimension;

    }

    public double getPixelDistance(){
        return pixelDistance;
    }

    public int getPixelMapDimension(){
        return pixelMapDimension;
    }

    public double getPixelStartY(){
        return pixelStartY;
    }

    public double getPixelStartX() {
        return pixelStartX;
    }

    public double getPixelEndX() {
        return pixelEndX;
    }

    public double getPixelEndY() {
        return pixelEndY;
    }
}

