package com.example.ludemo.Figur;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MinRektangel extends Rectangle implements MinFigur {

    private static int idCount = 5000;
    private int id;

    private final double INITIAL_X;
    private final double INITIAL_Y;

    public MinRektangel(MouseEvent e) {
        super(e.getX(), e.getY(), 0, 0);
        id=idCount++;
        INITIAL_X = e.getX();
        INITIAL_Y = e.getY();
        setFill(Color.color((Math.random()*255)/255, (Math.random()*255)/255, (Math.random()*255)/255));
        setStroke(Color.BLACK);
        setStrokeWidth(3);
    }

    @Override
    public void dragHandler(MouseEvent e) {
        double deltaX = e.getX() - INITIAL_X;
        double deltaY = e.getY() - INITIAL_Y;
        if(deltaX < 0) {
            setX(e.getX());
            setWidth(-deltaX);
        } else {
            setX(INITIAL_X);
            setWidth(deltaX);
        }
        if(deltaY < 0) {
            setY( e.getY() );
            setHeight(-deltaY);
        } else {
            setY(INITIAL_Y);
            setHeight(deltaY);
        }
    }

    @Override
    public MinFigurType getFigurType() {
        return MinFigurType.REKTANGEL;
    }

    @Override
    public String toString() {
        return getFigurType().toString()+": "+id;
    }
}
