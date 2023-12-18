package edu.fiuba.algo3.vista.paneles_de_visualizacion;

import edu.fiuba.algo3.vista.dado.DadoButton;
import edu.fiuba.algo3.vista.ElegirGladiadorPantalla;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.HashMap;

public class PanelLateralGladiadores extends VBox{

    private DadoButton dadoButton;
    private double altoImagenPerfil = 50 ;

    private double anchoImagenPerfil = 50;

    private ArrayList<Label> labelsGladiadores;
    private final String DIRECCION_IMAGEN_GLADIADOR = "File:src/main/resources/edu/fiuba/algo3/vista/mapa/components/perfilesGladiadores/PerfilGladiador";

    public PanelLateralGladiadores(DadoButton dadoButton){
        this.dadoButton = dadoButton;
        this.labelsGladiadores = new ArrayList<Label>();

    }

    public void actualizarGladiadorEnEspera(){
        for( int i = 0 ; i < this.labelsGladiadores.size() ; i++ ){
            if( this.labelsGladiadores.get(i).getTextFill() == Color.DARKGREEN ){
                this.labelsGladiadores.get(i).setTextFill(Color.WHITE);
                if( i == this.labelsGladiadores.size() - 1 ){
                    this.labelsGladiadores.get(0).setTextFill(Color.DARKGREEN);
                }else{
                    this.labelsGladiadores.get(i+1).setTextFill(Color.DARKGREEN);
                }
                break;
            }
        }
    }

    public void actualizarGladiadores(ArrayList<String> nombresGladiadores,
                                      HashMap<String, String> colorPorClaveNombreGladiador){
        this.getChildren().clear();
        this.labelsGladiadores.clear();
        this.getChildren().add(dadoButton);

        for( String nombreGladiador : nombresGladiadores ){
            String colorGladiador = colorPorClaveNombreGladiador.get(nombreGladiador);
            if( colorGladiador != null ){
                Label labelGladiador = agregarVistaGladiadorAndGetLabel(nombreGladiador, getDirImagenSegunColor(colorGladiador));
                this.labelsGladiadores.add(labelGladiador);
            }
        }
        this.labelsGladiadores.get(0).setTextFill(Color.DARKGREEN);

        this.setAlignment(Pos.CENTER);
        this.setSpacing(8);
        this.setPadding(new Insets(8));
        this.setStyle("-fx-background-color:#323232");
    }

    private String getDirImagenSegunColor(String color){
        String numero = ElegirGladiadorPantalla.getNumeroSegunColor(color);
        return DIRECCION_IMAGEN_GLADIADOR + numero + ".png";
    }

    private Label agregarVistaGladiadorAndGetLabel(String nombreGladiador, String dirImagen) {
        Image imagen = new Image(dirImagen);
        ImageView imagenPerfilGladiador = new ImageView(imagen);
        imagenPerfilGladiador.setFitHeight(altoImagenPerfil);
        imagenPerfilGladiador.setFitWidth(anchoImagenPerfil);

        Label nombreGladiadorLabel = new Label();
        nombreGladiadorLabel.setText(nombreGladiador);
        nombreGladiadorLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        nombreGladiadorLabel.setTextFill(Color.WHITE);

        this.getChildren().add(imagenPerfilGladiador);
        this.getChildren().add(nombreGladiadorLabel);

        return nombreGladiadorLabel;
    }
  


}

