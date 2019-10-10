package com.lexyn.pixeldesign.render;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Handle the @FXML canvas Object and handle all normal draw and resize events
 * @author lexyna
 */
public class RenderCanvas {

    private static RenderCanvas renderCanvas;

    private Canvas canvas;
    private GraphicsContext ctx;

    private double width, height;

    public static RenderCanvas getInstance(){
        if(renderCanvas == null){
            renderCanvas = new RenderCanvas();
        }
        return renderCanvas;
    }

    public static RenderCanvas getInstance(Canvas canvas){
        if(renderCanvas == null){
            renderCanvas = new RenderCanvas(canvas);

        }
        return renderCanvas;
    }

    private RenderCanvas(Canvas canvas){
        this.canvas = canvas;
        this.ctx = canvas.getGraphicsContext2D();
        this.width = canvas.getWidth();
        this.height = canvas.getHeight();
    }

    private RenderCanvas(){

    }

    public void drawBackground(){

        System.out.println(canvas.getWidth());

        ctx.setFill(Color.BLACK);
        ctx.fillRect(0,0, canvas.getWidth(), canvas.getHeight());

    }

}
