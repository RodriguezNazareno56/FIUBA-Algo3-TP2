package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.MovimientoException;
import edu.fiuba.algo3.modelo.MovimientoPausadoExeption;
import edu.fiuba.algo3.modelo.camino.Camino;
import edu.fiuba.algo3.modelo.celda.ICelda;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.TriunfoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mapa {
    private static final Logger logger = LoggerFactory.getLogger(Mapa.class);

    private int ancho;
    private int largo;
    private Camino camino;
    private HashMap<Gladiador, ICelda> posicionDeGladiadores;

    public Mapa(int ancho, int largo, Camino camino) {
        this.ancho = ancho;
        this.largo = largo;
        this.camino = camino;
        this.posicionDeGladiadores = new HashMap<>();
    }

    public Mapa(int ancho, int largo) {
        this.ancho = ancho;
        this.largo = largo;
        this.camino = new Camino(new ArrayList<>());
        this.posicionDeGladiadores = new HashMap<>();
    }

    public void setCamino(Camino camino) {
        this.camino = camino;
    }

    public void setGladiador(Gladiador gladiador) {
        posicionDeGladiadores.put(gladiador, camino.getCeldaSalida());
    }

    public void setGladiadores(List<Gladiador> gladiadorList) {
        gladiadorList.forEach( gladiador -> {
            posicionDeGladiadores.put(gladiador, camino.getCeldaSalida());
        });
    }

    public void avanzarNPosicionesGladiador(Gladiador gladiador, int posicionesCantidad) throws MovimientoPausadoExeption, MovimientoException {
        ICelda celdaActual = posicionDeGladiadores.get(gladiador);
        ICelda celdaDestino = this.camino.proximoEnNPosiciones(celdaActual, posicionesCantidad);

        gladiador.avanzar();
        this.posicionDeGladiadores.put(gladiador, celdaDestino);
        logger.info(gladiador + " avanza a " + celdaDestino.toString());
//        try {
//            gladiador.avanzar();
//            this.posicionDeGladiadores.put(gladiador, celdaDestino);
//        } catch (MovimientoPausadoExeption | MovimientoException e) {
//            throw new RuntimeException(e);
//        }

        try {
            celdaDestino.afectarGladiadorConConsecuencia(gladiador);
        } catch (TriunfoException e) {
            this.retrocederGladiadorAMitadDeCamino(gladiador);
        }
    }

    private void retrocederGladiadorAMitadDeCamino(Gladiador gladiador) {
        posicionDeGladiadores.put(gladiador, this.camino.getMitadDeCamino());
    }

    public void retrocederNPosicionesGladiador(Gladiador gladiador, int posicionesCantidad) throws MovimientoException {
        ICelda celdaActual = posicionDeGladiadores.get(gladiador);
        ICelda celdaDestino = this.camino.anteriorEnNPosiciones(celdaActual, posicionesCantidad);
        if (celdaDestino == celdaActual) {
            throw new MovimientoException("El gladiador no puede continuar retrocediendo");
        }
        this.posicionDeGladiadores.put(gladiador, celdaDestino);
    }

    public ICelda getPosicionDeGladiador(Gladiador gladiador) {
        return posicionDeGladiadores.get(gladiador);
    }

    @Override
    public String toString() {
        return "Mapa{" + "\n" +
                "ancho=" + ancho +
                ", largo=" + largo + "\n" +
                ", camino=" + camino +
                '}';
    }
}
