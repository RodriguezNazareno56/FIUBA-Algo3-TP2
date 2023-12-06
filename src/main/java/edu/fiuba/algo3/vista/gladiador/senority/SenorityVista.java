package edu.fiuba.algo3.vista.gladiador.senority;

import edu.fiuba.algo3.controladores.observers.ObservadorSenority;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.vista.gladiador.senority.states.NovatoStateVista;
import edu.fiuba.algo3.vista.gladiador.senority.states.SemiSeniorVista;
import edu.fiuba.algo3.vista.gladiador.senority.states.SeniorVista;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.ArrayDeque;
import java.util.Queue;

public class SenorityVista extends GridPane implements ObservadorSenority {

    private Queue<Label> senoritiesSiguientes;
    private Label senorityActual;

    public SenorityVista(Senority senority) {
        senoritiesSiguientes = new ArrayDeque<>();

        NovatoStateVista novatoStateVista = new NovatoStateVista();
        add(novatoStateVista, 0, 0);
        senorityActual = novatoStateVista;
        senorityActual.setTextFill(Color.RED);

        SemiSeniorVista semiSeniorVista = new SemiSeniorVista();
        add(semiSeniorVista, 0, 1);
        senoritiesSiguientes.add(semiSeniorVista);

        SeniorVista seniorVista = new SeniorVista();
        add(seniorVista, 0, 2);
        senoritiesSiguientes.add(seniorVista);

        senority.agregarObservador(this);
    }

    @Override
    public void actualizarPorAumentoDeSenority() {
        senorityActual.setTextFill(Color.GREY);
        senorityActual = senoritiesSiguientes.remove();
        senorityActual.setTextFill(Color.ORANGERED);
    }
}
