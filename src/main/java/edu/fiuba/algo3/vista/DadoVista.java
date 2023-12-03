package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Observable;
import edu.fiuba.algo3.modelo.Observador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import static java.lang.Long.MAX_VALUE;

public class DadoVista extends StackPane implements Observador {

    Dado dado;
    String srcImagenDado = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/dado/iconoDado";

    Button botonDado;

    public DadoVista(Dado dado){

        this.dado = dado;
        this.botonDado = new Button();

        actualizar();

        this.getChildren().add(botonDado);

        botonDado.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                dado.tirarDado();
                actualizar();
            }
        });

    }

    @Override
    public void actualizar() {

        Image imagen = new Image(this.srcImagenDado + this.dado.getUltimoValorArrojado() + ".png");
        ImageView imagenDado = new ImageView(imagen);
        imagenDado.setFitWidth(50);
        imagenDado.setFitHeight(50);
        this.botonDado.setGraphic(imagenDado);

    }


}
