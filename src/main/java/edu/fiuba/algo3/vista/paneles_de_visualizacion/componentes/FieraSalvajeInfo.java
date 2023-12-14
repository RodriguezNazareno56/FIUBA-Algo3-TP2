package edu.fiuba.algo3.vista.paneles_de_visualizacion.componentes;

import edu.fiuba.algo3.modelo.consecuencias.IConsecuencia;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class FieraSalvajeInfo extends VBox implements PantallaInfo {
    private final Label etiquetaJuego;

    public FieraSalvajeInfo(){
        super();

        this.setAlignment(Pos.BOTTOM_CENTER);
        this.setPadding(new Insets(20));
        this.etiquetaJuego = new Label();
        etiquetaJuego.setFont(Font.font("Helvetica", FontWeight.BOLD,38));
        etiquetaJuego.setTextFill(Color.web("#FFFFFF"));
        aplicarEfectosDeContornoTexto(etiquetaJuego);

        Label mensaje = new Label();
        mensaje.setFont(Font.font("Helvetica", FontWeight.BOLD,20));

        //mensaje.setText(mensajeGanador);
        mensaje.setText("toca para continuar");
        mensaje.setTextFill(Color.web("#FFFFFF"));
        aplicarEfectosDeContornoTexto(mensaje);


        this.setPadding(new Insets(20));
        Image imagen = new Image("File:src/main/resources/edu/fiuba/algo3/vista/imagenesConsecuencia/fieraSalvaje.png");

        Background background = new Background(new BackgroundFill(new ImagePattern(imagen), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY));
        this.setBackground(background);

        this.getChildren().addAll(etiquetaJuego,mensaje);
    }

    public VBox getPantallaConInfoDe(Gladiador gladiador, IConsecuencia consecuencia) {
        Energia energiaGladiador = gladiador.getEnergia();
        etiquetaJuego.setText(gladiador + " fue atacado por una fiera salvaje\n Le quedan " + energiaGladiador + " de energia ");
        return this;
    }

    private void aplicarEfectosDeContornoTexto(Label texto) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(3.0);
        dropShadow.setOffsetX(2.0);
        dropShadow.setOffsetY(2.0);
        dropShadow.setColor(Color.BLACK); // Color del contorno
        texto.setEffect(dropShadow);
    }
}
