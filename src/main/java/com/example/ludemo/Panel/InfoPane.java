package com.example.ludemo.Panel;

import com.example.ludemo.Figur.MinFigur;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.List;

public class InfoPane extends VBox {

    static class ShapeListBox extends HBox {

        private final ObservableList<Node> list;
        private final Node n;

        public ShapeListBox(Node n, ObservableList<Node> list) {
            this.list = list;
            this.n = n;
            Button up = new Button("UP");
            Button down = new Button("DN");
            up.setOnAction(this::upHandler);
            down.setOnAction(this::downHandler);
            getChildren().addAll(up, down, new Text((n.toString())));
        }

        private void upHandler(ActionEvent e){
            int nodeIndex = list.indexOf(n);
            if(nodeIndex<list.size()-1){
                Line tmp = new Line();
                Node n2 = list.get(nodeIndex+1);
                list.set(nodeIndex+1, tmp);
                list.set(nodeIndex, n2);
                list.set(nodeIndex+1, n);
            }
        }
        private void downHandler(ActionEvent e){
            int nodeIndex = list.indexOf(n);
            if(nodeIndex>0){
                Line tmp = new Line();
                Node n2 = list.get(nodeIndex-1);
                list.set(nodeIndex-1, tmp);
                list.set(nodeIndex, n2);
                list.set(nodeIndex-1, n);
            }
        }

    }

    Pane canvas;
    VBox liste = new VBox();
    VBox info = new VBox();
    public InfoPane(Pane canvas) {
        this.canvas = canvas;
        getChildren().add(liste);
        getChildren().add(new Text("ShapeInfo"));
        getChildren().add(info);

        liste.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        liste.setPadding(new Insets(5));
        info.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        info.setPadding(new Insets(5));


        canvas.getChildren().addListener((ListChangeListener<Node>) c -> {
            liste.getChildren().clear();
            for (Node n : c.getList()){
                Text text = new Text(n.toString());
                text.setOnMouseClicked(e->{
                    info.getChildren().clear();
                    info.getChildren().addAll(
                            new ShapeListBox(n, canvas.getChildren())
                    );
                });
                liste.getChildren().add(text);
            }
        });

        setPrefWidth(300);
        setBackground(new Background(new BackgroundFill(Color.WHEAT, CornerRadii.EMPTY, Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }
}
