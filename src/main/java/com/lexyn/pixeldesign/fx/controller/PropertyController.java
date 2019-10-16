package com.lexyn.pixeldesign.fx.controller;

import com.lexyn.pixeldesign.manager.ParticleSystemManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class PropertyController implements Initializable {

    @FXML
    private Spinner fx_XCoord, fx_YCoord;
    @FXML
    private Spinner fx_spawnRadiusMin, fx_spawnRadiusMax;
    @FXML
    private Spinner fx_spawnRateMin, fx_spawnRateMax;
    @FXML
    private Spinner fx_spawnIntervallMin, fx_spawnIntervallMax;

    public PropertyController(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fx_XCoord.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, ParticleSystemManager.getInstance().getActiveSystem().getPixelMap().getMapWidth(), 0 ,1 ));
        fx_YCoord.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, ParticleSystemManager.getInstance().getActiveSystem().getPixelMap().getMapHeight(), 0 ,1 ));

        fx_spawnRadiusMin.setValueFactory(createSimplespinner());
        fx_spawnRadiusMax.setValueFactory(createSimplespinner());

        fx_spawnRateMin.setValueFactory(createSimplespinner());
        fx_spawnRateMax.setValueFactory(createSimplespinner());

        fx_spawnIntervallMin.setValueFactory(createSimplespinner());
        fx_spawnIntervallMax.setValueFactory(createSimplespinner());

    }

    private SpinnerValueFactory createSimplespinner(){
        return new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0, 1);
    }
}
