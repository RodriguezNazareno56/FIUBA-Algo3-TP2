package edu.fiuba.algo3.vista.gladiador.senority.states;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SemiSeniorVista extends Label {

    public SemiSeniorVista() {
        setFont(Font.loadFont("file:src/main/resources/edu/fiuba/algo3/vista/fonts/BebasNeue-Regular.ttf", 20));
        setText("Semi señor");
        setTextFill(Color.GREY);
    }
}
