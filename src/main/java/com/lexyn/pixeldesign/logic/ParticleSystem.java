package com.lexyn.pixeldesign.logic;

import com.lexyn.pixeldesign.render.PixelRenderer;
import com.lexyn.pixeldesign.render.Renderer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.util.Duration;

/**
 * This class is a Management store  for all information that is currently displayed
 * and the render speed
 * @author lexyna
 */
public class ParticleSystem {

    private SimpleStringProperty name;

    private Renderer renderer;
    private PixelRenderer pixelRenderer;

    private PixelMap pixelMap;

    Timeline animationLoop;

    public ParticleSystem(Renderer renderer, PixelRenderer pixelRenderer, PixelMap pixelMap){
        name = new SimpleStringProperty("Particle Demo");
        this.renderer = renderer;
        this.pixelRenderer = pixelRenderer;
        this.pixelMap = pixelMap;

        animationLoop = new Timeline();
        animationLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.17),
                event -> {
                renderer.redraw();
                pixelMap.tick();
                pixelRenderer.highlightPixel(pixelMap.getMouseCoord());
                }
        );

        animationLoop.getKeyFrames().add(kf);
    }

    public void stopAnimation(){ animationLoop.stop();}

    public void playAnimation(){ animationLoop.play(); }

    public PixelMap getPixelMap(){
        return pixelMap;
    }

    public Renderer getRenderer(){
        return renderer;
    }

    public PixelRenderer getPixelRenderer() {
        return pixelRenderer;
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }
}
