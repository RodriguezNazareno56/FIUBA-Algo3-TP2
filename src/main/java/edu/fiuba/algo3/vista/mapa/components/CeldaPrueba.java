package edu.fiuba.algo3.vista.mapa.components;

import edu.fiuba.algo3.modelo.consecuencias.EquipamientoIncrementado;
import edu.fiuba.algo3.modelo.consecuencias.IConsecuencia;
import edu.fiuba.algo3.vista.equipamientos.EquipamientoPremio;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class CeldaPrueba extends VBox {

    private static final String PATH_TEXTURA_CELDA = "File:src/main/resources/edu/fiuba/algo3/vista/mapa/components/TexturaCelda-100-100.png";

    public CeldaPrueba(double alto, double ancho, List<IConsecuencia> consecuencias){
        super(50);
        this.configurarGraficaCelda(alto,ancho, consecuencias);
    }


    private void configurarGraficaCelda(double alto, double ancho, List<IConsecuencia> consecuencias){
        Image imagen = new Image(PATH_TEXTURA_CELDA);
        ImageView imagenCelda = new ImageView(imagen);
        imagenCelda.setFitWidth(ancho);
        imagenCelda.setFitHeight(alto);

        this.setMaxHeight(alto);
        this.setMaxWidth(ancho);
        this.getChildren().addAll(new EquipamientoPremio(),new EquipamientoPremio());
    }

    public EquipamientoPremio equipamientoPremio (List<IConsecuencia> consecuencias){
        return consecuencias.stream()
                .filter(consecuencia -> consecuencia.equals(new EquipamientoIncrementado()))
                .findFirst()
                .map(consecuencia -> new EquipamientoPremio())
                .orElse(null);
    }
}
