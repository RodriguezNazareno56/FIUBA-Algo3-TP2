package edu.fiuba.algo3.vista.paneles_de_visualizacion.componentes;

import edu.fiuba.algo3.modelo.consecuencias.IConsecuencia;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class EquipamientoIncrementadoInfo extends VBox implements PantallaInfo {
    private final StackPane contenedorPrincipal;
    private final Label etiquetaJuego;

    public EquipamientoIncrementadoInfo(){
        super();

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));
        this.etiquetaJuego = new Label();
        etiquetaJuego.setFont(Font.font("Helvetica", FontWeight.BOLD,42));
        etiquetaJuego.setTextFill(Color.web("#FFFFFF"));
        aplicarEfectosDeContornoTexto(etiquetaJuego);
        etiquetaJuego.setWrapText(true);
        etiquetaJuego.setTextAlignment(TextAlignment.CENTER);

        //Contenedor principal
        StackPane contenedorPrincipal = new StackPane();
        this.getChildren().add(contenedorPrincipal);
        this.contenedorPrincipal = contenedorPrincipal;


        Label mensaje = new Label();
        mensaje.setFont(Font.font("Helvetica", FontWeight.BOLD,20));

        //mensaje.setText(mensajeGanador);
        mensaje.setText("toca para continuar");
        mensaje.setTextFill(Color.web("#FFFFFF"));
        aplicarEfectosDeContornoTexto(mensaje);


        this.setPadding(new Insets(20));
        Image imagen = new Image("File:src/main/resources/edu/fiuba/algo3/vista/imagenesConsecuencia/equipamiento.png");

        Background background = new Background(new BackgroundFill(new ImagePattern(imagen), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY));
        this.setBackground(background);

        this.getChildren().addAll(etiquetaJuego,mensaje);
    }

    public VBox getPantallaConInfoDe(Gladiador gladiador, IConsecuencia consecuencia) {
        //imagen del nuevo equipamiento
        Equipamiento equipamiento = gladiador.getEquipamiento();
        String url = "file:src/main/resources/edu/fiuba/algo3/vista/equipamientos/" + equipamiento + ".png";
        Image gladiadorImage = new Image(url);
        ImageView imageView = new ImageView(gladiadorImage);
        contenedorPrincipal.getChildren().add(imageView);

        etiquetaJuego.setText("El " + gladiador + " Consiguió " + equipamiento);
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