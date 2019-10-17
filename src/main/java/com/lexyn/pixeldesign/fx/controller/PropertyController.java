package com.lexyn.pixeldesign.fx.controller;

import com.lexyn.pixeldesign.logic.emitter.Emitter;
import com.lexyn.pixeldesign.manager.ParticleSystemManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
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
    private Slider fx_spawnRadiusMinS, fx_spawnRadiusMaxS;

    @FXML
    private Spinner fx_spawnRateMin, fx_spawnRateMax;
    @FXML
    private Slider fx_spawnRateMinS,fx_spawnRateMaxS;

    @FXML
    private Spinner fx_spawnIntervallMin, fx_spawnIntervallMax;
    @FXML
    private Slider fx_spawnIntervallMinS, fx_spawnIntervallMaxS;
    @FXML
    private ColorPicker fx_particleColor;


    public PropertyController(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fx_XCoord.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, ParticleSystemManager.getInstance().getActiveSystem().getPixelMap().getMapWidth(), 0 ,1 ));
        fx_YCoord.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, ParticleSystemManager.getInstance().getActiveSystem().getPixelMap().getMapHeight(), 0 ,1 ));

        fx_spawnRadiusMin.setValueFactory(createSimplespinner());
        fx_spawnRadiusMax.setValueFactory(createSimplespinner());

        bindSliderToSpinner(fx_spawnRadiusMinS, fx_spawnRadiusMin);
        bindSliderToSpinner(fx_spawnRadiusMaxS, fx_spawnRadiusMax);

        fx_spawnRateMin.setValueFactory(createSimplespinner());
        fx_spawnRateMax.setValueFactory(createSimplespinner());

        bindSliderToSpinner(fx_spawnRateMinS, fx_spawnRateMin);
        bindSliderToSpinner(fx_spawnRateMaxS, fx_spawnRateMax);

        fx_spawnIntervallMin.setValueFactory(createSimplespinner());
        fx_spawnIntervallMax.setValueFactory(createSimplespinner());

        bindSliderToSpinner(fx_spawnIntervallMinS, fx_spawnIntervallMin);
        bindSliderToSpinner(fx_spawnIntervallMaxS, fx_spawnIntervallMax);
    }

    public void bindParamsToEmitter(Emitter emitter){
        emitter.spawnRateMinProperty().bindBidirectional(fx_spawnRateMin.getValueFactory().valueProperty());
        emitter.spawnRateMaxProperty().bindBidirectional(fx_spawnRateMax.getValueFactory().valueProperty());
        emitter.spawnRadiusMinProperty().bindBidirectional(fx_spawnRadiusMin.getValueFactory().valueProperty());
        emitter.spawnRadiusMaxProperty().bindBidirectional(fx_spawnRadiusMax.getValueFactory().valueProperty());
        emitter.spawnIntervallMinProperty().bindBidirectional(fx_spawnIntervallMin.getValueFactory().valueProperty());
        emitter.spawnIntervallMaxProperty().bindBidirectional(fx_spawnIntervallMax.getValueFactory().valueProperty());
        emitter.coordX().bindBidirectional(fx_XCoord.getValueFactory().valueProperty());
        emitter.coordY().bindBidirectional(fx_YCoord.getValueFactory().valueProperty());
        fx_particleColor.setOnAction(e -> emitter.setParticleColor(fx_particleColor.getValue()));
    }

    private void bindSliderToSpinner(Slider slider, Spinner spinner){
        slider.valueProperty().bindBidirectional(spinner.getValueFactory().valueProperty());
    }

    private SpinnerValueFactory createSimplespinner(){
        return new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 100, 0, 1);
    }
}
