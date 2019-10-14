package com.lexyn.pixeldesign.fx.cellfactory;

import com.lexyn.pixeldesign.logic.emitter.Emitter;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class EmitterListCell extends ListCell<Emitter> {

    private final TextField textField = new TextField();

    public EmitterListCell() {
        textField.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                cancelEdit();
            }
        });
        textField.setOnAction(e -> {
            getItem().setName(textField.getText());
            setText(textField.getText());
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        });
        setGraphic(textField);
    }

    @Override
    protected void updateItem(Emitter emitter, boolean empty) {
        super.updateItem(emitter, empty);
        if (isEditing()) {
            textField.setText(emitter.getName());
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        } else {
            setContentDisplay(ContentDisplay.TEXT_ONLY);
            if (empty) {
                setText(null);
            } else {
                setText(emitter.getName());
            }
        }
    }

    @Override
    public void startEdit() {
        super.startEdit();
        textField.setText(getItem().getName());
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        textField.requestFocus();
        textField.selectAll();
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        setText(getItem().getName());
        setContentDisplay(ContentDisplay.TEXT_ONLY);
    }

}
