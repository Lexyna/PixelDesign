package com.lexyn.pixeldesign.render;

import com.lexyn.pixeldesign.logic.PixelMap;
import com.lexyn.pixeldesign.render.transformation.TransformationMatrix;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


/**
 * Handles all render operation on the pixel Map
 */
public class PixelRenderer {

    private static PixelRenderer pixelRender;

    public static PixelRenderer getInstance(){
        if(pixelRender == null)
            pixelRender = new PixelRenderer();
        return pixelRender;
    }

    private Canvas canvas;
    private GraphicsContext ctx;

    private PixelRenderer(){
    }

    public void renderPixelGrid(){
        for(var i = 0; i < PixelMap.getInstance().getMapWidth(); i++){
            ctx.setStroke(Color.BLACK);
            ctx.strokeLine(i * TransformationMatrix.getInstance().getPixelWdith(), 0, i * TransformationMatrix.getInstance().getPixelWdith(), canvas.getHeight());
        }
        for(var i = 0; i < PixelMap.getInstance().getMapHeight(); i++){
            ctx.setStroke(Color.BLACK);
            ctx.strokeLine(0, i * TransformationMatrix.getInstance().getPixelHeight(), canvas.getWidth(), i * TransformationMatrix.getInstance().getPixelHeight());
        }
    }

    public void  setCanvas(Canvas canvas){
        this.canvas = canvas;
        this.ctx = canvas.getGraphicsContext2D();
    }

}
