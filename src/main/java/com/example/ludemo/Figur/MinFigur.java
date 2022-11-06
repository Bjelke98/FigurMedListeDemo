package com.example.ludemo.Figur;

import javafx.scene.input.MouseEvent;

public interface MinFigur {
    void dragHandler(MouseEvent e);
    MinFigurType getFigurType();
}
