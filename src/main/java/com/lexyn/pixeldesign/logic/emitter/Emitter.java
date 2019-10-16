package com.lexyn.pixeldesign.logic.emitter;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;

import java.io.IOException;
import java.io.Serializable;

/**
 * the main source of particle effect, store and calculated all data relevant for
 * particles to render
 * @author lexyna
 */
public class Emitter implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private ScrollPane propertyPane;
    private Node propertyNode;

    public Emitter(){}

    public Emitter(String name, ScrollPane propertyPane){
        this.name = name;
        this.propertyPane = propertyPane;
        createPropertyContent();
    }

    private void createPropertyContent() {
        try {
            propertyNode = FXMLLoader.load(this.getClass().getResource("/fxml/propertyStage.fxml"));
            setProperty();
        }catch (IOException ex){

        }
    }

    public void setProperty(){
        propertyPane.setContent(propertyNode);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o){
        if(o == this)
            return true;

        if(!(o instanceof Emitter))
            return false;

        Emitter copy = (Emitter) o;

        return this.getName().equals(copy.getName());
    }
}
