package com.lexyn.pixeldesign.render;

import com.lexyn.pixeldesign.color.PixelColor;
import com.lexyn.pixeldesign.coord.PixelCoordinate;
import com.lexyn.pixeldesign.logic.emitter.Particle;
import com.lexyn.pixeldesign.manager.ParticleSystemManager;
import com.lexyn.pixeldesign.render.transformation.TransformationMatrix;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


/**
 * Handles all render operation on the pixel Map
 */
public class PixelRenderer {

    private Canvas canvas;
    private GraphicsContext ctx;

    public PixelRenderer(Canvas canvas){
        this.canvas = canvas;
        this.ctx = this.canvas.getGraphicsContext2D();
    }

    public void highlightPixel(PixelCoordinate pixel){

        if(!pixel.isValid())
            return;

        ParticleSystemManager.getInstance().getActiveSystem().getRenderer().redraw();
        ParticleSystemManager.getInstance().getActiveSystem().getPixelMap().redraw();
        ctx.setFill(Color.web("#999999"));
        ctx.fillRect(pixel.getX() * TransformationMatrix.getInstance().getPixelDistance() + TransformationMatrix.getInstance().getPixelStartX(),
                pixel.getY() * TransformationMatrix.getInstance().getPixelDistance() + TransformationMatrix.getInstance().getPixelStartY(),
                TransformationMatrix.getInstance().getPixelDistance(),
                TransformationMatrix.getInstance().getPixelDistance());
    }

    public void renderPixel(PixelCoordinate pixel, PixelColor color){

        if(!pixel.isValid())
            return;

        ctx.setFill(Color.rgb(color.getRed(), color.getGreen(), color.getBlue(), color.getOpacity()));
        ctx.fillRect(pixel.getX() * TransformationMatrix.getInstance().getPixelDistance() + TransformationMatrix.getInstance().getPixelStartX(),
                pixel.getY() * TransformationMatrix.getInstance().getPixelDistance() + TransformationMatrix.getInstance().getPixelStartY(),
                TransformationMatrix.getInstance().getPixelDistance(),
                TransformationMatrix.getInstance().getPixelDistance());
    }

    public void renderPixelGrid(){
        for(var i = 0; i < ParticleSystemManager.getInstance().getActiveSystem().getPixelMap().getMapWidth() + 1; i++){

            ctx.setStroke(Color.BLACK);
            ctx.beginPath();

            ctx.moveTo(i * TransformationMatrix.getInstance().getPixelDistance() + TransformationMatrix.getInstance().getPixelStartX()
                    , TransformationMatrix.getInstance().getPixelStartY());
            ctx.lineTo(i * TransformationMatrix.getInstance().getPixelDistance() + TransformationMatrix.getInstance().getPixelStartX(),
                    TransformationMatrix.getInstance().getPixelEndY());
            ctx.stroke();

        }
        for(var i = 0; i < ParticleSystemManager.getInstance().getActiveSystem().getPixelMap().getMapHeight() + 1; i++){

            ctx.beginPath();

            ctx.moveTo(TransformationMatrix.getInstance().getPixelStartX(),
                    i * TransformationMatrix.getInstance().getPixelDistance() + TransformationMatrix.getInstance().getPixelStartY());
            ctx.lineTo(TransformationMatrix.getInstance().getPixelEndX(),
                    i * TransformationMatrix.getInstance().getPixelDistance() + TransformationMatrix.getInstance().getPixelStartY());
            ctx.stroke();
            ctx.setStroke(Color.BLACK);
        }
    }

}
