package com.example.ludemo;

import com.example.ludemo.Figur.MinFigurType;
import com.example.ludemo.Panel.InfoPane;
import com.example.ludemo.Panel.MinCanvas;
import com.example.ludemo.State.AppState;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    MinCanvas canvas = new MinCanvas();
    InfoPane infoPane = new InfoPane(canvas);

    @Override
    public void start(Stage stage) throws IOException {

        BorderPane root = new BorderPane();

        root.setCenter(canvas);
        root.setRight(infoPane);

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Demo");
        stage.setScene(scene);
        stage.show();

        scene.setOnKeyPressed(this::keyPressHandler);

    }

    private void keyPressHandler(KeyEvent e){

        switch (e.getCode()){
            case DIGIT1 -> AppState.drawNext = MinFigurType.SIRKEL;
            case DIGIT2 -> AppState.drawNext = MinFigurType.REKTANGEL;
        }

    }

    public static void main(String[] args) {
        launch();
    }
}