package com.lexyn.pixeldesign.logic.emitter;

import com.lexyn.pixeldesign.color.PixelColor;
import com.lexyn.pixeldesign.coord.PixelCoordinate;
import com.lexyn.pixeldesign.manager.ParticleSystemManager;

/***
 * A Particle is generated by an Emitter and represents exactly 1 pixel on the screen
 * @author lexyna
 */
public class Particle {

    private int x,y;
    private PixelColor color;

    private int lifetime;
    private int speedX, speedY;


    public Particle(int x, int y, int lifetime, int speedX, int speedY, PixelColor color){
        this.x = x;
        this.y = y;
        this.lifetime = lifetime;
        this.speedX = speedX;
        this.speedY = speedY;
        this.color = color;

    }

    public void tick(){

        lifetime -= 1;

        x += speedX;
        y += speedY;


    }

    public void render(){
        ParticleSystemManager.getInstance().getActiveSystem().getPixelRenderer().renderPixel(new PixelCoordinate(x,y ), color);
    }

    public int getLifetime(){
        return lifetime;
    }

}
