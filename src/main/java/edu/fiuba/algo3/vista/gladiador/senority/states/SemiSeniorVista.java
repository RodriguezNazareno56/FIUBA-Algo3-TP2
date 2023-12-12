package edu.fiuba.algo3.vista.gladiador.senority.states;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class SemiSeniorVista extends Label {

    public SemiSeniorVista() {
        setFont(Font.font("Helvetica", FontWeight.BOLD, 11));
        setText("SEMI SEÑOR");
        setTextFill(Color.GREY);

    }
}
