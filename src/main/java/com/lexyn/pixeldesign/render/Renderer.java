package com.lexyn.pixeldesign.render;

import com.lexyn.pixeldesign.manager.ParticleSystemManager;
import com.lexyn.pixeldesign.render.transformation.TransformationMatrix;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 * Handle the @FXML canvas Object and handle all normal draw and resize events
 * @author lexyna
 */
public class Renderer {


    protected Canvas canvas;
    private GraphicsContext ctx;

    public Renderer(Canvas canvas){
        this.canvas = canvas;
        this.ctx = this.canvas.getGraphicsContext2D();
    }

    public void resize(){
        TransformationMatrix.getInstance().calculatePixel(canvas.getWidth(), canvas.getHeight());
        redraw();
    }

    public void redraw(){
        drawBackground();
        if(ParticleSystemManager.getInstance().getActiveSystem().getPixelMap().isRenderGrid())
            ParticleSystemManager.getInstance().getActiveSystem().getPixelRenderer().renderPixelGrid();
    }

    public void drawBackground(){

        ctx.setFill(ParticleSystemManager.getInstance().getActiveSystem().getPixelMap().getBackgroundColor());
        ctx.fillRect(0,0, canvas.getWidth(), canvas.getHeight());

    }

}
