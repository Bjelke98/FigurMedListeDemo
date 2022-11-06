package com.example.ludemo.Figur;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MinSirkel extends Circle implements MinFigur {

    private static int idCount = 1000;
    private int id;

    public MinSirkel(MouseEvent e) {
        super(e.getX(), e.getY(), 0);
        id=idCount++;
        setFill(Color.color((Math.random()*255)/255, (Math.random()*255)/255, (Math.random()*255)/255));
        setStroke(Color.BLACK);
        setStrokeWidth(3);
    }

    @Override
    public void dragHandler(MouseEvent e) {
        setRadius(
            Math.sqrt(
                (e.getX() - getCenterX()) * (e.getX() - getCenterX())+
                (e.getY() - getCenterY()) * (e.getY() - getCenterY())
            )
        );
    }

    @Override
    public MinFigurType getFigurType() {
        return MinFigurType.SIRKEL;
    }

    @Override
    public String toString() {
        return getFigurType().toString()+": "+id;
    }
}
