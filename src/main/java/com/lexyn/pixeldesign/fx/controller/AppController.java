package com.lexyn.pixeldesign.fx.controller;

import com.lexyn.pixeldesign.fx.tab.EditableTab;
import com.lexyn.pixeldesign.manager.ParticleSystemManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    @FXML
    TabPane fx_tabPane;
    @FXML
    MenuItem fx_newFile;

    @Override
    public void initialize(URL location, ResourceBundle bundle){

        ParticleSystemManager.getInstance(fx_tabPane);

        createTab();

        fx_tabPane.getSelectionModel().selectedIndexProperty().addListener(e -> ParticleSystemManager.getInstance().changeActiveSystem());
        //The Policy consumes the left click event for the TabPane
        fx_tabPane.setTabDragPolicy(TabPane.TabDragPolicy.REORDER);

        fx_newFile.setOnAction(e -> createTab());

    }

    private void createTab(){
        try{
            Tab tab = new EditableTab(new SimpleStringProperty("Particle Demo"));
            tab.setOnCloseRequest(e -> ParticleSystemManager.getInstance().removeParticleSystem(fx_tabPane.getTabs().indexOf(tab)));
            fx_tabPane.getTabs().add(tab);
            tab.setContent(FXMLLoader.load(this.getClass().getResource("/fxml/mainStage.fxml")));
        }catch (IOException e){

        }
    }

}