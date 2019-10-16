package com.lexyn.pixeldesign.fx.cellfactory;

import com.lexyn.pixeldesign.logic.emitter.Emitter;
import javafx.collections.ObservableList;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.input.*;

import java.util.ArrayList;
import java.util.List;

public class EmitterListCell extends ListCell<Emitter> {

    private static final DataFormat emitterFormat = new DataFormat("com.lexyn.pixeldesign.logic.emitter.Emitter");

    private final TextField textField = new TextField();

    public EmitterListCell() {
        ListCell<Emitter> thisCell = this;
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

        dragAndDrop(thisCell);
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

    private void dragAndDrop(ListCell<Emitter> thisCell){
        setOnDragDetected(e -> {
            if(getItem() == null)
                return;

            Dragboard dragboard = startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.put(emitterFormat, getItem());
            dragboard.setContent(content);
            e.consume();

        });

        setOnDragOver(e -> {
            if(e.getGestureSource() != thisCell
                    && e.getDragboard().hasContent(emitterFormat)) {
                e.acceptTransferModes(TransferMode.MOVE);
            }
            e.consume();
        });

        setOnDragEntered(e -> {
            if(e.getGestureSource() != thisCell
                    && e.getDragboard().hasContent(emitterFormat)) {
                setOpacity(0.3);
            }
            e.consume();
        });

        setOnDragExited(e -> {
            if(e.getGestureSource() != thisCell
                    && e.getDragboard().hasContent(emitterFormat)) {
                setOpacity(1);
            }
        });

        setOnDragDropped(e -> {
            if(getItem() == null)
                return;

            Dragboard db = e.getDragboard();
            boolean success = false;

            if(db.hasContent(emitterFormat)){
                ObservableList<Emitter> items = getListView().getItems();
                int draggedIndex = items.indexOf(db.getContent(emitterFormat));
                int draggedTo = items.indexOf(getItem());

                items.set(draggedIndex, getItem());
                items.set(draggedTo,(Emitter) db.getContent(emitterFormat));

                List<Emitter> copy = new ArrayList<>(getListView().getItems());
                getListView().getItems().setAll(copy);

                success = true;
            }
            e.setDropCompleted(success);
            e.consume();
        });

        setOnDragDone(e -> e.consume());
    }

}
