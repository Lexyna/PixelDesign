package com.lexyn.pixeldesign.coord;

import com.lexyn.pixeldesign.logic.PixelMap;

public class PixelCoordinate {

    int x, y;

    public PixelCoordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean isValid(){
        if(this.x < 0 || this.y < 0
                || this.x > PixelMap.getInstance().getMapWidth() || this.y > PixelMap.getInstance().getMapHeight())
            return false;
        return true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
