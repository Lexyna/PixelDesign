package com.lexyn.pixeldesign.logic;

import com.lexyn.pixeldesign.logic.emitter.Emitter;
import com.lexyn.pixeldesign.logic.emitter.Particle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Handle all events and metadata on the pixel map
 * @author lexyna
 */
public class PixelMap {

    private int mapWidth, mapHeight;
    private Color backgroundColor;

    private ObservableList<Emitter> emitters;
    private ArrayList<Particle> particles;

    public PixelMap(int mapWidth, int mapHeight, Color color){
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.backgroundColor = color;
        emitters = FXCollections.observableArrayList();
        particles = new ArrayList<>();
    }

    /**
     * update the Map, tick all emitters and particles
     */
    public void tick(){

        for(int i = 0; i < emitters.size(); i++)
            emitters.get(i).tick();


        Iterator<Particle> it = particles.iterator();
        while(it.hasNext()){
            Particle p = it.next();
            p.tick();
            p.render();
            if(p.getLifetime() == 0)
                it.remove();
        }


    }

    public void addParticle(Particle p){
        particles.add(p);
    }

    public int getMapWidth(){
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public ObservableList getEmitters(){ return emitters;}

}
