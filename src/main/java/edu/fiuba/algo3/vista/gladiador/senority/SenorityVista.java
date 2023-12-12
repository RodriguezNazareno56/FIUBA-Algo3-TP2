package edu.fiuba.algo3.vista.gladiador.senority;

import edu.fiuba.algo3.controladores.observers.ObservadorSenority;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.vista.gladiador.senority.states.NovatoStateVista;
import edu.fiuba.algo3.vista.gladiador.senority.states.SemiSeniorVista;
import edu.fiuba.algo3.vista.gladiador.senority.states.SeniorVista;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayDeque;
import java.util.Queue;

public class SenorityVista extends StackPane implements ObservadorSenority {

    private Queue<Label> senoritiesSiguientes;
    private Label senorityActual;


    public SenorityVista(Senority senority) {

        senoritiesSiguientes = new ArrayDeque<>();

        //Imagen de fondo
        ImageView imagenFondoSenorityVista = new ImageView("File:src/main/resources/edu/fiuba/algo3/vista/senority/SeniorityBoxBackGround.png");
        imagenFondoSenorityVista.setFitHeight(110);
        imagenFondoSenorityVista.setFitWidth(110);
        this.getChildren().add(imagenFondoSenorityVista);

        // Lista de posibles senorities
        GridPane senoritiesVistas = new GridPane();

        NovatoStateVista novatoStateVista = new NovatoStateVista();
        senoritiesVistas.add(novatoStateVista, 0, 0);
        GridPane.setHalignment(novatoStateVista, HPos.CENTER);
        senorityActual = novatoStateVista;
        senorityActual.setTextFill(Color.SADDLEBROWN);

        SemiSeniorVista semiSeniorVista = new SemiSeniorVista();
        senoritiesVistas.add(semiSeniorVista, 0, 1);
        GridPane.setHalignment(semiSeniorVista, HPos.CENTER);
        senoritiesSiguientes.add(semiSeniorVista);

        SeniorVista seniorVista = new SeniorVista();
        senoritiesVistas.add(seniorVista, 0, 2);
        GridPane.setHalignment(seniorVista, HPos.CENTER);
        senoritiesSiguientes.add(seniorVista);

        senoritiesVistas.setAlignment(Pos.CENTER);
        senority.agregarObservador(this);


        this.setAlignment(Pos.CENTER);
        this.getChildren().add(senoritiesVistas);


    }

    @Override
    public void actualizarPorAumentoDeSenority() {
        senorityActual.setTextFill(Color.GREY);
        senorityActual = senoritiesSiguientes.remove();
        senorityActual.setTextFill(Color.SADDLEBROWN);
    }
}
