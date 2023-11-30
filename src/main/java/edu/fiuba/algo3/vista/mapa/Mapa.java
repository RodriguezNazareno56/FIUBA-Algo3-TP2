package edu.fiuba.algo3.vista.mapa;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Mapa extends Pane {

    public Mapa(){
        super();

        Rectangle rectangle = new Rectangle();
        rectangle.setX(100);
        rectangle.setY(700);
        rectangle.setWidth(50);
        rectangle.setHeight(50);
        rectangle.setStroke(Color.TRANSPARENT);
        rectangle.setFill(Color.valueOf("#00ffff"));

        Rectangle rectangle1 = new Rectangle();
        rectangle1.setX(200);
        rectangle1.setY(700);
        rectangle1.setWidth(50);
        rectangle1.setHeight(50);
        rectangle1.setStroke(Color.TRANSPARENT);
        rectangle1.setFill(Color.valueOf("#00ffff"));

        Rectangle rectangle2 = new Rectangle();
        rectangle2.setX(200);
        rectangle2.setY(600);
        rectangle2.setWidth(50);
        rectangle2.setHeight(50);
        rectangle2.setStroke(Color.TRANSPARENT);
        rectangle2.setFill(Color.valueOf("#00ffff"));

        Rectangle rectangle3 = new Rectangle();
        rectangle3.setX(200);
        rectangle3.setY(500);
        rectangle3.setWidth(50);
        rectangle3.setHeight(50);
        rectangle3.setStroke(Color.TRANSPARENT);
        rectangle3.setFill(Color.valueOf("#00ffff"));


        Rectangle rectangle4 = new Rectangle();
        rectangle4.setX(200);
        rectangle4.setY(400);
        rectangle4.setWidth(50);
        rectangle4.setHeight(50);
        rectangle4.setStroke(Color.TRANSPARENT);
        rectangle4.setFill(Color.valueOf("#00ffff"));

        Rectangle rectangle5 = new Rectangle();
        rectangle5.setX(200);
        rectangle5.setY(300);
        rectangle5.setWidth(50);
        rectangle5.setHeight(50);
        rectangle5.setStroke(Color.TRANSPARENT);
        rectangle5.setFill(Color.valueOf("#00ffff"));

        this.getChildren().add(rectangle);
        this.getChildren().add(rectangle1);
        this.getChildren().add(rectangle2);
        this.getChildren().add(rectangle3);
        this.getChildren().add(rectangle4);
        this.getChildren().add(rectangle5);
    }
}