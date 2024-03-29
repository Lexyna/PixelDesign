package com.lexyn.pixeldesign.fx.controller;

import com.lexyn.pixeldesign.color.PixelColor;
import com.lexyn.pixeldesign.logic.emitter.Emitter;
import com.lexyn.pixeldesign.manager.ParticleSystemManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class PropertyController implements Initializable {

    @FXML
    private Spinner<Integer> fx_XCoord, fx_YCoord;

    @FXML
    private Spinner<Double> fx_spawnRadiusMin, fx_spawnRadiusMax;
    @FXML
    private Slider fx_spawnRadiusMinS, fx_spawnRadiusMaxS;

    @FXML
    private Spinner<Double> fx_spawnRateMin, fx_spawnRateMax;
    @FXML
    private Slider fx_spawnRateMinS,fx_spawnRateMaxS;

    @FXML
    private Spinner<Double> fx_spawnIntervallMin, fx_spawnIntervallMax;
    @FXML
    private Slider fx_spawnIntervallMinS, fx_spawnIntervallMaxS;
    @FXML
    private ColorPicker fx_particleColor;

    @FXML
    private Spinner<Double> fx_velocityXMin, fx_velocityXMax;
    @FXML
    private Slider fx_velocityXMinS, fx_velocityXMaxS;
    @FXML
    private Spinner<Double> fx_velocityYMin, fx_velocityYMax;
    @FXML
    private Slider fx_velocityYMinS, fx_velocityYMaxS;


    @FXML
    private Spinner<Double> fx_pLifetimeMin, fx_pLifetimeMax;
    @FXML
    private Slider fx_pLifetimeMinS, fx_pLifetimeMaxS;

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

        fx_pLifetimeMin.setValueFactory(createSimplespinner());
        fx_pLifetimeMax.setValueFactory(createSimplespinner());

        bindSliderToSpinner(fx_pLifetimeMinS, fx_pLifetimeMin);
        bindSliderToSpinner(fx_pLifetimeMaxS, fx_pLifetimeMax);

        fx_velocityXMin.setValueFactory(createSimplespinner());
        fx_velocityXMax.setValueFactory(createSimplespinner());

        bindSliderToSpinner(fx_velocityXMaxS, fx_velocityXMax);
        bindSliderToSpinner(fx_velocityXMinS, fx_velocityXMin);

        fx_velocityYMin.setValueFactory(createSimplespinner());
        fx_velocityYMax.setValueFactory(createSimplespinner());

        bindSliderToSpinner(fx_velocityYMaxS, fx_velocityYMax);
        bindSliderToSpinner(fx_velocityYMinS, fx_velocityYMin);

    }

    public void setParams(int x, int y, double radMin, double radMax, double rateMin, double rateMax, double interMin, double interMax, PixelColor color){
        fx_XCoord.getValueFactory().setValue(x);
        fx_YCoord.getValueFactory().setValue(y);
        fx_spawnRadiusMin.getValueFactory().setValue(radMin);
        fx_spawnRadiusMax.getValueFactory().setValue(radMax);
        fx_spawnRateMin.getValueFactory().setValue(rateMin);
        fx_spawnRateMax.getValueFactory().setValue(rateMax);
        fx_spawnIntervallMin.getValueFactory().setValue(interMin);
        fx_spawnIntervallMax.getValueFactory().setValue(interMax);
        fx_particleColor.setValue(Color.rgb(color.getRed(), color.getGreen(), color.getBlue(), color.getOpacity()));
    }

    public void bindParamsToEmitter(Emitter emitter){
        fx_spawnRadiusMin.valueProperty().addListener((obs, oldVal, newVal) -> {emitter.setSpawnRadiusMin(newVal.intValue());});
        fx_spawnRadiusMax.valueProperty().addListener((obs, oldVal, newVal) -> {emitter.setSpawnRadiusMax(newVal.intValue());});
        fx_spawnRateMin.valueProperty().addListener((obs, oldVal, newVal) -> {emitter.setSpawnRateMin(newVal.intValue());});
        fx_spawnRateMax.valueProperty().addListener((obs, oldVal, newVal) -> {emitter.setSpawnRateMax(newVal.intValue());});
        fx_spawnIntervallMin.valueProperty().addListener((obs, oldVal, newVal) -> {emitter.setSpawnIntervallMin(newVal.intValue());});
        fx_spawnIntervallMax.valueProperty().addListener((obs, oldVal, newVal) -> {emitter.setSpawnIntervallMax(newVal.intValue());});
        fx_XCoord.valueProperty().addListener((obs, oldVal, newVal) -> {emitter.setCoordX(newVal);});
        fx_YCoord.valueProperty().addListener((obs, oldVal, newVal) -> {emitter.setCoordY(newVal);});
        fx_pLifetimeMin.valueProperty().addListener((obs, oldVal, newVal) -> {emitter.setpLifetimeMin(newVal.intValue());});
        fx_pLifetimeMax.valueProperty().addListener((obs, oldVal, newVal) -> {emitter.setpLifetimeMax(newVal.intValue());});
        fx_velocityXMin.valueProperty().addListener((obs, oldVal, newVal) -> {emitter.setpVelocityXMin(newVal.intValue());});
        fx_velocityXMax.valueProperty().addListener((obs, oldVal, newVal) -> {emitter.setpVelocityXMax(newVal.intValue());});
        fx_velocityYMin.valueProperty().addListener((obs, oldVal, newVal) -> {emitter.setpVelocityYMin(newVal.intValue());});
        fx_velocityYMax.valueProperty().addListener((obs, oldVal, newVal) -> {emitter.setpVelocityYMax(newVal.intValue());});
        fx_particleColor.setOnAction(e -> {
                    Color c = fx_particleColor.getValue();
                    emitter.setParticleColor(new PixelColor(
                            (int)(c.getRed() * 255),
                            (int)(c.getGreen() * 255),
                            (int)(c.getBlue() * 255),
                            c.getOpacity()));
        });
    }

    private void bindSliderToSpinner(Slider slider, Spinner spinner){
        slider.valueProperty().bindBidirectional(spinner.getValueFactory().valueProperty());
        slider.valueProperty().addListener((obs, oldVal, newVal) -> slider.setValue(newVal.intValue()));
    }

    private SpinnerValueFactory createSimplespinner(){
        return new SpinnerValueFactory.DoubleSpinnerValueFactory(1, 100, 1, 1);
    }
}
