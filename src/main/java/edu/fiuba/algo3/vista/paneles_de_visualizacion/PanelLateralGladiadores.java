package edu.fiuba.algo3.vista.paneles_de_visualizacion;

import edu.fiuba.algo3.controladores.observers.ObservadorAlgoRoma;
import edu.fiuba.algo3.controladores.observers.ObservadorSenority;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.vista.pantalla_elegir_gladiador.ElegirGladiadorPantalla;
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

// TODO: renombrar a panelGladiadores
public class PanelLateralGladiadores extends VBox implements ObservadorSenority, ObservadorAlgoRoma {



    private AlgoRoma algoRoma;

    private ArrayList imagenesPerfilGladiador;

    private double maxCantidadPerfiles = 6;

    private double altoImagenPerfil = 60 ;

    private double anchoImagenPerfil = 60;

    private HashMap<String, String> colorPorClaveNombreGladiador;

    private ArrayList<String> nombresAgregados;
    private ArrayList<Label> labelsGladiadores;
    private final String DIRECCION_IMAGEN_GLADIADOR = "File:src/main/resources/edu/fiuba/algo3/vista/mapa/components/perfilesGladiadores/PerfilGladiador";

    public PanelLateralGladiadores(AlgoRoma algoRoma, HashMap<String, String> colorPorClaveNombreGladiador){

        this.algoRoma = algoRoma;
        this.imagenesPerfilGladiador = new ArrayList<String>();
        this.colorPorClaveNombreGladiador = colorPorClaveNombreGladiador;
        this.nombresAgregados = new ArrayList<String>();
        this.labelsGladiadores = new ArrayList<Label>();

        //Inicializo vector de imagenes de los perfiles
        String srcImage = "File:src/main/resources/edu/fiuba/algo3/vista/mapa/components/perfilesGladiadores/PerfilGladiador";

        for( int i = 1 ; i <= maxCantidadPerfiles ; i++ ){
            this.imagenesPerfilGladiador.add( srcImage + i + ".png" );
        }

    }

    public void agregarGladiador(){

        int cantidadGladiadores = algoRoma.getGladiadores().size();


        Image imagen = new Image(String.valueOf(this.imagenesPerfilGladiador.get(cantidadGladiadores - 1)));
        ImageView imagenPerfilGladiador = new ImageView(imagen);
        imagenPerfilGladiador.setFitHeight(altoImagenPerfil);
        imagenPerfilGladiador.setFitWidth(anchoImagenPerfil);

        Label nombreGladiador = new Label();
        nombreGladiador.setText(algoRoma.getGladiadores().get(cantidadGladiadores - 1).getNombre());
        nombreGladiador.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        nombreGladiador.setTextFill(Color.WHITE);

        this.getChildren().add(imagenPerfilGladiador);
        this.getChildren().add(nombreGladiador);



        this.setAlignment(Pos.CENTER);
        this.setSpacing(8);
        this.setPadding(new Insets(8));
        this.setStyle("-fx-background-color:#323232");

    }

    @Override
    public void visualizarProximoPanelInferior(){

        this.actualizarLabelNuevoTurno();
    }

    private void actualizarLabelNuevoTurno(){
        // si el label esta en darkgreen pongo el siguiente label en darkgreen y los demas en white

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


    @Override
    public void visualizarNuevoGladiador(){
        //this.actualizarNuevoGladiadorConImagen();

        //this.mostrarGladiadoresEnOrden();

        this.setAlignment(Pos.CENTER);
        this.setSpacing(8);
        this.setPadding(new Insets(8));
        this.setStyle("-fx-background-color:#323232");

    }

    private void actualizarNuevoGladiadorConImagen(){
        ArrayList<Gladiador> gladiadores = algoRoma.getGladiadores();

        for( Gladiador gladiador : gladiadores ){
            String nombreGladiador = gladiador.getNombre();
            String dirImagen = this.colorPorClaveNombreGladiador.get(nombreGladiador);
            if( dirImagen != null && !nombresAgregados.contains(nombreGladiador) ){
                nombresAgregados.add(nombreGladiador);

                agregarVistaGladiador(nombreGladiador, dirImagen);
            }
        }
    }

    public void mostrarGladiadoresEnOrden(){
        ArrayList<String> nombresGladiadores = algoRoma.getNombresGladiadoresSegunOrdenEnRonda();

        for( String nombreGladiador : nombresGladiadores ){
            String colorGladiador = this.colorPorClaveNombreGladiador.get(nombreGladiador);
            if( colorGladiador != null && !nombresAgregados.contains(nombreGladiador) ){

                this.labelsGladiadores.add(agregarVistaGladiador(nombreGladiador, getImagenSegunColor(colorGladiador)));
            }
        }
        this.labelsGladiadores.get(0).setTextFill(Color.DARKGREEN);
    }

    private String getImagenSegunColor(String color){
        String numero = ElegirGladiadorPantalla.getNumeroSegunColor(color);
        return DIRECCION_IMAGEN_GLADIADOR + numero + ".png";
    }

    private Label agregarVistaGladiador(String nombreGladiador, String dirImagen) {
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
  
  @Override
    public void actualizarPorAumentoDeSenority() {
        
    }

}

