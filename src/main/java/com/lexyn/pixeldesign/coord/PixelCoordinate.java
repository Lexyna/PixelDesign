package com.lexyn.pixeldesign.coord;

import com.lexyn.pixeldesign.manager.ParticleSystemManager;

public class PixelCoordinate {

    int x, y;

    public PixelCoordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean isValid(){
        return !(this.x < 0
                || this.y < 0
                || this.x >= ParticleSystemManager.getInstance().getActiveSystem().getPixelMap().getMapWidth()
                || this.y >= ParticleSystemManager.getInstance().getActiveSystem().getPixelMap().getMapHeight());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
