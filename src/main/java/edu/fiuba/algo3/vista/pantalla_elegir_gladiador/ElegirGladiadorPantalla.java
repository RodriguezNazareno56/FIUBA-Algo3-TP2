package edu.fiuba.algo3.vista.pantalla_elegir_gladiador;

import edu.fiuba.algo3.controladores.GladiadorFactory;
import edu.fiuba.algo3.controladores.observers.ObservadorAlgoRoma;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.vista.menuBarra.MenuBarra;
import edu.fiuba.algo3.vista.pantalla_elegir_gladiador.componentes.JugarPartidaButtonEventHandler;
import edu.fiuba.algo3.vista.AlgoRomaPantalla;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;


public class ElegirGladiadorPantalla extends BorderPane implements ObservadorAlgoRoma {

    private HashMap<Image, String> direccionesPorImage = new HashMap<>();

    private HashMap<String, String> colorPorClaveNombreGladiador;

    private AlgoRoma algoRoma;

    private HBox gladiadoresElegidosHBox;

    private Button botonSiguienteEscena;

    private SelectorGladiadorVista selectorGladiador;

    private final int ESPACIADO_GLADIADORES_ELEGIDOS = 60;

    private final String DIRECCION_IMAGENES = "File:src/main/resources/edu/fiuba/algo3/vista/mapa/components/perfilesGladiadores/PerfilGladiador";
    // File:src/main/resources/edu/fiuba/algo3/vista/mapa/components/perfilesGladiadores/PerfilGladiador1.png sin el 1.png, debe ser png por ahora

    private final int ESPACIADO_BLOQUES = 40;
    public ElegirGladiadorPantalla(Stage stage, Scene escenaSiguiente, AlgoRoma algoRoma, AlgoRomaPantalla algoRomaPantalla,
                                   HashMap<String,String> colorPorClaveNombreGladiador, AudioClip sonidoFondo) {
        super();

        MenuBarra menuBarra = new MenuBarra(stage, sonidoFondo);
        this.setTop(menuBarra);


        VBox contenedorElegirGladiador = new VBox();

        this.algoRoma = algoRoma;
        algoRoma.agregarObservadorNuevoGladiador(this);
        this.colorPorClaveNombreGladiador = colorPorClaveNombreGladiador;

        this.gladiadoresElegidosHBox = new HBox();
        gladiadoresElegidosHBox.setAlignment(Pos.CENTER);
        gladiadoresElegidosHBox.setSpacing(ESPACIADO_GLADIADORES_ELEGIDOS);

        GladiadorFactory gladiadorFactory = new GladiadorFactory(algoRoma, algoRomaPantalla);
        this.selectorGladiador = new SelectorGladiadorVista(this.getImageSeleccionablesGladiadores(), gladiadorFactory);

        botonSiguienteEscena = new Button("Jugar");
        botonSiguienteEscena.setOnAction(new JugarPartidaButtonEventHandler(stage, escenaSiguiente, algoRoma, algoRomaPantalla));
        botonSiguienteEscena.setStyle("-fx-background-color: #006600; -fx-text-fill: white; -fx-font-size: 28px;-fx-background-radius: 10;");

        this.actualizarBotonSiguienteEscena();


        contenedorElegirGladiador.getChildren().addAll(this.gladiadoresElegidosHBox, selectorGladiador);
        contenedorElegirGladiador.getChildren().add(botonSiguienteEscena);

        contenedorElegirGladiador.setAlignment(Pos.CENTER);
        contenedorElegirGladiador.setSpacing(ESPACIADO_BLOQUES);

        //poner otra imagen, esta imagen no contrasta bien con las fotos
        Image imagen = new Image("file:src/main/resources/edu/fiuba/algo3/vista/ElegirGladiadorPantallaBackground.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(
                imagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        contenedorElegirGladiador.setBackground(new Background(imagenDeFondo));
        this.setCenter(contenedorElegirGladiador);
    }


    @Override
    public void update() {
        this.actualizarGladiadoresElegidos();
    }

    private void actualizarGladiadoresElegidos(){
        ArrayList<String> nombreGladiadores = algoRoma.getNombresGladiadoresSegunOrdenDeIngreso();

        for(String nombreGladiador : nombreGladiadores){
            // si el gladiador no esta en el hashmap entonces lo agrego con la imagen del selector
            if(!this.colorPorClaveNombreGladiador.containsKey(nombreGladiador)){
                Image imageElegida = this.selectorGladiador.getAndDeleteImagenElegidaParaGladiador();

                GladiadorElegidoVista gladiadorNuevoVista = new GladiadorElegidoVista(nombreGladiador, imageElegida);
                this.gladiadoresElegidosHBox.getChildren().add(gladiadorNuevoVista);


                String color = getColorSegunNumeroImagen(this.conseguirNumeroImagen(this.direccionesPorImage.get(imageElegida)));
                this.colorPorClaveNombreGladiador.put(nombreGladiador, color);

                this.actualizarBotonSiguienteEscena();
                this.actualizarBotonesSelectorGladiador();
            }
        }

    }

    private void actualizarBotonSiguienteEscena(){
        if( algoRoma.getNombresGladiadoresSegunOrdenDeIngreso().size() < algoRoma.getMinimaCantidadGladiadores()){
            botonSiguienteEscena.setDisable(true);
        }
        else{
            botonSiguienteEscena.setDisable(false);
        }
    }

    private void actualizarBotonesSelectorGladiador(){
        if(algoRoma.getNombresGladiadoresSegunOrdenDeIngreso().size() >= algoRoma.getMaximaCantidadGladiadores()){
            //selectorGladiador.setDesactivarBotonEnviarNombre(true);
            selectorGladiador.desactivarBotones(true);
        }
        else{
            //selectorGladiador.setDesactivarBotonEnviarNombre(false);
            selectorGladiador.desactivarBotones(false);

        }
    }

    public ArrayList<Image> getImageSeleccionablesGladiadores() {
        ArrayList<Image> imagenes = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            String direccionImagen = this.DIRECCION_IMAGENES + i + ".png";
            Image imageSeleccionable = new Image(direccionImagen);
            imagenes.add(imageSeleccionable);

            this.direccionesPorImage.put(imageSeleccionable, direccionImagen);
        }
        return imagenes;
    }

    private String conseguirNumeroImagen(String direccionImagen){
        // el numero de imagen se encuentra antes del tipo de imagen, por lo tanto hare un split

        String[] partes = direccionImagen.split(".png");

        return partes[0].substring(partes[0].length() - 1);
    }
    public static String getColorSegunNumeroImagen(String nombreImagen){
        //posible refactor a algun tipo de lista enlazada o algo asi y a otra clase
        String color = "gris";

        switch (nombreImagen) {
            case "1":
                color= "rojo";
                break;
            case "2":
                color= "azul";
                break;
            case "3":
                color= "verde";
                break;
            case "4":
                color= "amarillo";
                break;
            case "5":
                color= "violeta";
                break;
            case "6":
                color= "celeste";
                break;
        }
        return color;

    }

    public static String getNumeroSegunColor(String color){
        String numero = "1";

        switch (color) {
            case "rojo":
                numero= "1";
                break;
            case "azul":
                numero= "2";
                break;
            case "verde":
                numero= "3";
                break;
            case "amarillo":
                numero= "4";
                break;
            case "violeta":
                numero= "5";
                break;
            case "celeste":
                numero= "6";
                break;
        }
        return numero;

    }
}
