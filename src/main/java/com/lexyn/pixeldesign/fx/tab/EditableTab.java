package com.lexyn.pixeldesign.fx.tab;

import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

public class EditableTab extends Tab {

    public EditableTab(StringProperty name){
        Label label = new Label();

        label.textProperty().bind(name);
        setGraphic(label);

        TextField textField = new TextField();


        label.setOnMouseClicked(e -> {
                System.out.println("clicked");
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

}
