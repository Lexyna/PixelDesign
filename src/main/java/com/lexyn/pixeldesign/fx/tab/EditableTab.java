package com.lexyn.pixeldesign.fx.tab;

import com.lexyn.pixeldesign.manager.ParticleSystemManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

public class EditableTab extends Tab {

    StringProperty name;

    public EditableTab(){

        name = new SimpleStringProperty();

        TextField textField = new TextField();
        Label label = new Label();

        label.textProperty().bind(name);
        setGraphic(label);

        label.setOnMouseClicked(e -> {
                if (e.getClickCount() == 2) {
                    textField.setText(label.getText());
                    setGraphic(textField);
                    textField.selectAll();
                    textField.requestFocus();

                }
        });

        textField.setOnAction( e -> {
            name.setValue(textField.getText());
            setGraphic(label);
        });

        textField.focusedProperty().addListener((observable, oldVal, newVal) -> {
            if(!newVal){
                name.setValue(textField.getText());
                setGraphic(label);
            }
        });
    }

    public StringProperty nameProperty() {
        return name;
    }
}
