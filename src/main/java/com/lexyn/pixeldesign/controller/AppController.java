package com.lexyn.pixeldesign.controller;

import com.lexyn.pixeldesign.manager.SystemManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    @FXML
    TabPane fx_tabPane;

    @Override
    public void initialize(URL location, ResourceBundle bundle){

        SystemManager.getInstance(fx_tabPane);

        try{
            Tab tab = new Tab();
            fx_tabPane.getTabs().add(tab);
            tab.setContent((Node) FXMLLoader.load(this.getClass().getResource("/fxml/mainStage.fxml")));
            tab.setText("Particle Demo");
        }catch (IOException e){

        }

    }

}
