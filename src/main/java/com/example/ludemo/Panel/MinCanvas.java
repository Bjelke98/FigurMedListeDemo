package com.example.ludemo.Panel;

import com.example.ludemo.Figur.MinFigur;
import com.example.ludemo.Figur.MinRektangel;
import com.example.ludemo.Figur.MinSirkel;
import com.example.ludemo.State.AppState;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class MinCanvas extends Pane {

    private Shape shape;
    public MinCanvas() {
        setOnMousePressed(this::pressHandler);
        setOnMouseDragged(this::dragHandler);
    }

    private void pressHandler(MouseEvent e){
        switch (AppState.drawNext){
            case SIRKEL -> shape = new MinSirkel(e);
            case REKTANGEL -> shape = new MinRektangel(e);
        }

        switch (AppState.drawNext){
            case SIRKEL, REKTANGEL -> getChildren().add(shape);
        }

    }

    private void dragHandler(MouseEvent e){
        switch (AppState.drawNext){
            case SIRKEL, REKTANGEL -> ((MinFigur)shape).dragHandler(e);
        }
    }

}
