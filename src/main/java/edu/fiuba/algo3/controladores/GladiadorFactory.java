package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.constantes.Constantes;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.vista.equipamientos.EquipamientosPanel;
import edu.fiuba.algo3.vista.gladiador.EnergiaVista;
import edu.fiuba.algo3.vista.gladiador.GladiadorAnimado;
import edu.fiuba.algo3.vista.gladiador.senority.SenorityVista;
import edu.fiuba.algo3.vista.mapa.AlgoRomaPantalla;
import edu.fiuba.algo3.vista.panel.PanelInferior;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GladiadorFactory {

    private AlgoRoma algoRoma;
    private AlgoRomaPantalla algoRomaPantalla;

    public GladiadorFactory(AlgoRoma algoRoma, AlgoRomaPantalla algoRomaPantalla) {
        this.algoRoma = algoRoma;
        this.algoRomaPantalla = algoRomaPantalla;
    }

    // TODO: a renombrar
    public void crearGladiador(String nombreGladiador) throws NombreInvalidoException,
            MaximoGladiadoresException, JuegoEnCursoException, FinDelJuegoException {

        Energia energia = new Energia(Constantes.ENERGIA_DEL_GLADIADOR_VALOR_INICIAL);
        EnergiaVista energiaVista = new EnergiaVista(energia, Constantes.ENERGIA_DEL_GLADIADOR_VALOR_INICIAL);

        SinEquipamiento equipamiento = new SinEquipamiento();

        Senority senority = new Senority();
        SenorityVista senorityVista = new SenorityVista(senority);

        Logger logger = LoggerFactory.getLogger(Gladiador.class);

        Gladiador gladiador = new Gladiador(nombreGladiador, energia, equipamiento, senority, logger);
        GladiadorAnimado gladiadorAnimado = new GladiadorAnimado(nombreGladiador,GladiadorAnimado.ColoresGladiador.GRIS);

        EquipamientosPanel equipamientosPanel = new EquipamientosPanel(gladiador);

        PanelInferior panelInferior = new PanelInferior(new edu.fiuba.algo3.vista.gladiador.Gladiador(100),
                energiaVista,
                senorityVista,
                equipamientosPanel);

        algoRoma.agregarGladiador(gladiador);
        algoRomaPantalla.agregarPanelInferiorDeJugador(panelInferior);
        algoRomaPantalla.agregarGladiador(gladiadorAnimado);
    }
}

