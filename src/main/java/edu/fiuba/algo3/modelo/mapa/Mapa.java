package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.controladores.observers.ObservableMapa;
import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoException;
import edu.fiuba.algo3.modelo.gladiador.exepciones.MovimientoException;
import edu.fiuba.algo3.modelo.camino.Camino;
import edu.fiuba.algo3.modelo.celda.ICelda;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.exepciones.TriunfoNoPosibleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Mapa extends ObservableMapa {
    private static final Logger logger = LoggerFactory.getLogger(Mapa.class);

    private int ancho;
    private int largo;
    private Camino camino;
    private HashMap<Gladiador, ICelda> posicionDeGladiadores;

    public Mapa(int ancho, int largo, Camino camino) {
        super();
        this.ancho = ancho;
        this.largo = largo;
        this.camino = camino;
        this.posicionDeGladiadores = new HashMap<>();
    }

    public Mapa(int ancho, int largo) {
        super();
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

    public void avanzarNPosicionesGladiador(Gladiador gladiador, int posicionesCantidad) throws MovimientoException, FinDelJuegoException {
        ICelda celdaActual = posicionDeGladiadores.get(gladiador);
        ICelda celdaDestino = this.camino.proximoEnNPosiciones(celdaActual, posicionesCantidad);

        gladiador.avanzar();
        this.posicionDeGladiadores.put(gladiador, celdaDestino);
        logger.info(gladiador + " avanza a " + celdaDestino.toString());

        try {
            celdaDestino.afectarGladiadorConConsecuencia(gladiador);
        } catch (TriunfoNoPosibleException e) {
            this.retrocederGladiadorAMitadDeCamino(gladiador);
        }
        notificarPosicionamientoDeGladiador(gladiador, celdaDestino.getCoordenada());
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

    public Camino getCamino(){
        return this.camino;
    }

    @Override
    public String toString() {
        return "Mapa{" + "\n" +
                "ancho=" + ancho +
                ", largo=" + largo + "\n" +
                ", camino=" + camino +
                '}';
    }

    // Dos Mapas son iguales cuando tiene el mismo ancho, largo y mismo camino
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mapa mapa = (Mapa) o;
        return ancho == mapa.ancho &&
                largo == mapa.largo &&
                Objects.equals(camino, mapa.camino);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ancho, largo, camino);
    }
}
