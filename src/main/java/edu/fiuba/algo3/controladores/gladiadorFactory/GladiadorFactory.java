package edu.fiuba.algo3.controladores.gladiadorFactory;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoException;
import edu.fiuba.algo3.modelo.excepciones.JuegoEnCursoException;
import edu.fiuba.algo3.modelo.excepciones.MaximoGladiadoresException;
import edu.fiuba.algo3.modelo.excepciones.NombreInvalidoException;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.vista.equipamientos.EquipamientosPanel;
import edu.fiuba.algo3.vista.gladiador.EnergiaVista;
import edu.fiuba.algo3.vista.gladiador.GladiadorAnimado;
import edu.fiuba.algo3.vista.gladiador.GladiadorVista;
import edu.fiuba.algo3.vista.gladiador.senority.SenorityVista;
import edu.fiuba.algo3.vista.AlgoRomaPantalla;
import edu.fiuba.algo3.vista.paneles_de_visualizacion.PanelInferior;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;

import static edu.fiuba.algo3.modelo.constantes.GladiadorConstantes.ENERGIA_INICIAL_GLADIADOR;

public class GladiadorFactory {

    private AlgoRomaModelo algoRoma;
    private AlgoRomaPantalla algoRomaPantalla;
    private Deque<GladiadorVista.Color> coloresGladiadorVista;
    private Deque<GladiadorAnimado.Color> coloresGladiadorAnimado;
    private GladiadorAnimado.Color colorGladiadorAnimado;
    private GladiadorVista.Color colorGladiadorVista;

    public GladiadorFactory(AlgoRomaModelo algoRoma, AlgoRomaPantalla algoRomaPantalla) {
        this.algoRoma = algoRoma;
        this.algoRomaPantalla = algoRomaPantalla;
        inicializarColores();
        avanzarColor();
    }

    // TODO: a renombrar
    public void crearGladiador(String nombreGladiador) throws NombreInvalidoException,
            MaximoGladiadoresException, JuegoEnCursoException, FinDelJuegoException {

        Energia energia = new Energia(ENERGIA_INICIAL_GLADIADOR);
        EnergiaVista energiaVista = new EnergiaVista(energia, ENERGIA_INICIAL_GLADIADOR);

        SinEquipamiento equipamiento = new SinEquipamiento();

        Senority senority = new Senority();
        SenorityVista senorityVista = new SenorityVista(senority);

        Logger logger = LoggerFactory.getLogger(Gladiador.class);

        Gladiador gladiador = new Gladiador(nombreGladiador, energia, equipamiento, senority, logger);
        GladiadorAnimado gladiadorAnimado = new GladiadorAnimado(nombreGladiador, colorGladiadorAnimado);
        GladiadorVista gladiadorImageParaPanel = new GladiadorVista(nombreGladiador, colorGladiadorVista);

        EquipamientosPanel equipamientosPanel = new EquipamientosPanel(gladiador);

        PanelInferior panelInferior = new PanelInferior(
                gladiadorImageParaPanel,
                energiaVista,
                senorityVista,
                equipamientosPanel);

        algoRoma.agregarGladiador(gladiador);
        algoRomaPantalla.agregarPanelInferiorDeJugador(panelInferior);
        algoRomaPantalla.agregarGladiador(gladiadorAnimado);

        avanzarColor();
    }

    private void avanzarColor() {
        this.colorGladiadorAnimado = coloresGladiadorAnimado.pop();
        coloresGladiadorAnimado.add(colorGladiadorAnimado);

        this.colorGladiadorVista = coloresGladiadorVista.pop();
        coloresGladiadorVista.add(colorGladiadorVista);
    }

    private void inicializarColores() {
        coloresGladiadorAnimado = new ArrayDeque<>();
        coloresGladiadorAnimado.add(GladiadorAnimado.Color.GRIS);
        coloresGladiadorAnimado.add(GladiadorAnimado.Color.MARRON);
        coloresGladiadorAnimado.add(GladiadorAnimado.Color.DORADO);

        coloresGladiadorVista = new ArrayDeque<>();
        coloresGladiadorVista.add(GladiadorVista.Color.GRIS);
        coloresGladiadorVista.add(GladiadorVista.Color.MARRON);
        coloresGladiadorVista.add(GladiadorVista.Color.DORADO);
    }
}

