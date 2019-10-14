package com.lexyn.pixeldesign.manager;

import com.lexyn.pixeldesign.logic.ParticleSystem;
import javafx.fxml.FXML;
import javafx.scene.control.TabPane;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is dedicated to keeping track of the currently focused Tab
 * @author lexyna
 */
public class ParticleSystemManager {

    private static ParticleSystemManager systemManager;

    public static ParticleSystemManager getInstance(TabPane fx_tabPane){
        if(systemManager == null)
            systemManager = new ParticleSystemManager(fx_tabPane);
        return systemManager;
    }

    public static ParticleSystemManager getInstance(){
        if(systemManager == null)
            return null;
        return systemManager;
    }

    private List<ParticleSystem> systems;

    ParticleSystem activeSystem;

    @FXML
    TabPane fx_tabPane;

    public ParticleSystemManager(TabPane fx_tabPane){
        this.fx_tabPane = fx_tabPane;
        this.systems = new ArrayList<>();
    }

    public void changeActiveSystem(){
        if(fx_tabPane.getSelectionModel().getSelectedIndex() >= 0 && systems.size() > 0) {
            activeSystem = systems.get(fx_tabPane.getSelectionModel().getSelectedIndex());
            activeSystem.getRenderer().resize();
        }
    }

    public ParticleSystem getActiveSystem(){
        return activeSystem;
    }

    public void addSystem(ParticleSystem system){
        this.systems.add(system);
        activeSystem = system;
        fx_tabPane.getSelectionModel().selectLast();
    }

    public void removeParticleSystem(int index){
        systems.remove(index);
        if(index == fx_tabPane.getSelectionModel().getSelectedIndex() && index > 0) {
            activeSystem = systems.get(index - 1);
            fx_tabPane.getSelectionModel().select(index - 1);
        }
    }

}
