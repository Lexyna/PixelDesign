package com.lexyn.pixeldesign.logic.emitter;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

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
    private AnchorPane propertyNode;

    public Emitter(){}

    public Emitter(String name){
        this.name = name;
        try {
            propertyNode = FXMLLoader.load(this.getClass().getResource("/fxml/propertyStage.fxml"));
        }catch (IOException ex){

        }
    }

    public void setProperty(ScrollPane propertyPane){
        propertyPane.setContent(propertyNode);
        propertyNode.prefWidthProperty().bind(propertyPane.widthProperty());
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
