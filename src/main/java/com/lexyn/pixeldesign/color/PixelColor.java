package com.lexyn.pixeldesign.color;

import java.io.Serializable;

public class PixelColor implements Serializable {

    private int red, green, blue;

    private double opacity;

    public PixelColor(int red, int green, int blue, double opacity){
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.opacity = opacity;
    }

    public int getBlue() {
        return blue;
    }

    public int getGreen() {
        return green;
    }

    public int getRed() {
        return red;
    }

    public double getOpacity() {
        return opacity;
    }

    @Override
    public boolean equals(Object o){
        if(o == this)
            return  true;

        if(!(o instanceof PixelColor))
            return false;

        PixelColor copy = (PixelColor) o;

        return (this.red == copy.red && this.green == copy.green && this.blue == copy.blue && this.opacity == copy.opacity);

    }
}
