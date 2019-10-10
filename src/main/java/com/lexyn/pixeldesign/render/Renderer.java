package com.lexyn.pixeldesign.render;

import com.lexyn.pixeldesign.logic.PixelMap;
import com.lexyn.pixeldesign.render.transformation.TransformationMatrix;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 * Handle the @FXML canvas Object and handle all normal draw and resize events
 * @author lexyna
 */
public class Renderer {

    private static Renderer renderer;

    protected Canvas canvas;
    private GraphicsContext ctx;

    public static Renderer getInstance(){
        if(renderer == null)
            renderer = new Renderer();
        return renderer;
    }

    public Renderer(){}

    public void resize(){
        TransformationMatrix.getInstance().calculatePixel(canvas.getWidth(), canvas.getHeight());
        drawBackground();
        PixelRenderer.getInstance().renderPixelGrid();
    }

    public void drawBackground(){

        ctx.setFill(PixelMap.getInstance().getBackgroundColor());
        ctx.fillRect(0,0, canvas.getWidth(), canvas.getHeight());

    }

    public void setCanvas(Canvas canvas){
        this.canvas = canvas;
        this.ctx = canvas.getGraphicsContext2D();
    }

}
