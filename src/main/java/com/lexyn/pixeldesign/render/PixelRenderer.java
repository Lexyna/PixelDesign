package com.lexyn.pixeldesign.render;

import com.lexyn.pixeldesign.coord.PixelCoordinate;
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

    private PixelRenderer(){}

    public void highlightPixel(PixelCoordinate pixel){

        if(!pixel.isValid())
            return;

        ctx.setFill(Color.web("#999999"));
        ctx.fillRect(pixel.getX() * TransformationMatrix.getInstance().getPixelDistance() + TransformationMatrix.getInstance().getPixelStartX(),
                pixel.getY() * TransformationMatrix.getInstance().getPixelDistance() + TransformationMatrix.getInstance().getPixelStartY(),
                TransformationMatrix.getInstance().getPixelDistance(),
                TransformationMatrix.getInstance().getPixelDistance());
    }

    public void renderPixelGrid(){
        for(var i = 0; i < PixelMap.getInstance().getMapWidth() + 1; i++){

            ctx.setStroke(Color.BLACK);
            ctx.beginPath();

            ctx.moveTo(i * TransformationMatrix.getInstance().getPixelDistance() + TransformationMatrix.getInstance().getPixelStartX()
                    , TransformationMatrix.getInstance().getPixelStartY());
            ctx.lineTo(i * TransformationMatrix.getInstance().getPixelDistance() + TransformationMatrix.getInstance().getPixelStartX(),
                    TransformationMatrix.getInstance().getPixelEndY());
            ctx.stroke();

        }
        for(var i = 0; i < PixelMap.getInstance().getMapHeight() + 1; i++){

            ctx.beginPath();

            ctx.moveTo(TransformationMatrix.getInstance().getPixelStartX(),
                    i * TransformationMatrix.getInstance().getPixelDistance() + TransformationMatrix.getInstance().getPixelStartY());
            ctx.lineTo(TransformationMatrix.getInstance().getPixelEndX(),
                    i * TransformationMatrix.getInstance().getPixelDistance() + TransformationMatrix.getInstance().getPixelStartY());
            ctx.stroke();
            ctx.setStroke(Color.BLACK);
        }
    }

    public void  setCanvas(Canvas canvas){
        this.canvas = canvas;
        this.ctx = canvas.getGraphicsContext2D();
    }

}
