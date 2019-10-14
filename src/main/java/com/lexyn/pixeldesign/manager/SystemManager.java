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
public class SystemManager {

    private static SystemManager systemManager;

    public static SystemManager getInstance(TabPane fx_tabPane){
        if(systemManager == null)
            systemManager = new SystemManager(fx_tabPane);
        return systemManager;
    }

    public static SystemManager getInstance(){
        if(systemManager == null)
            return null;
        return systemManager;
    }

    private List<ParticleSystem> systems;

    ParticleSystem activeSystem;

    @FXML
    TabPane fx_tabPane;

    public SystemManager(TabPane fx_tabPane){
        this.fx_tabPane = fx_tabPane;
        this.systems = new ArrayList<>();
    }

    public void changeActiveSystem(){
        activeSystem = systems.get(fx_tabPane.getSelectionModel().getSelectedIndex());
    }

    public ParticleSystem getActiveSystem(){
        return activeSystem;
    }

    public void addSystem(ParticleSystem system){
        this.systems.add(system);
        activeSystem = system;
    }

}
