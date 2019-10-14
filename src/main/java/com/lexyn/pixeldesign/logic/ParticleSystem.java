package com.lexyn.pixeldesign.logic;

import com.lexyn.pixeldesign.render.PixelRenderer;
import com.lexyn.pixeldesign.render.Renderer;

/**
 * This class is a Managment store  for all information that is currently display
 * and the render speed
 * @author lexyna
 */
public class ParticleSystem {

    private Renderer renderer;
    private PixelRenderer pixelRenderer;

    private PixelMap pixelMap;

    public ParticleSystem(Renderer renderer, PixelRenderer pixelRenderer, PixelMap pixelMap){
        this.renderer = renderer;
        this.pixelRenderer = pixelRenderer;
        this.pixelMap = pixelMap;
    }

    public PixelMap getPixelMap(){
        return pixelMap;
    }

    public Renderer getRenderer(){
        return renderer;
    }

    public PixelRenderer getPixelRenderer() {
        return pixelRenderer;
    }
}
