package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.MovimientoException;
import edu.fiuba.algo3.modelo.MovimientoPausadoExeption;
import edu.fiuba.algo3.modelo.camino.Camino;
import edu.fiuba.algo3.modelo.celda.ICelda;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.TriunfoException;

import java.util.HashMap;
import java.util.List;

public class Mapa {
    private int ancho;
    private int largo;
    private Camino camino;
    private HashMap<Gladiador, ICelda> posicionDeGladiadores;

    public Mapa(int ancho, int largo, Camino camino, List<Gladiador> gladiadorList) {
        this.ancho = ancho;
        this.largo = largo;
        this.camino = camino;
        this.posicionDeGladiadores = new HashMap<>();
        gladiadorList.forEach( gladiador -> {
            posicionDeGladiadores.put(gladiador, camino.getCasilleroSalida());
        });
    }

    public Mapa(int ancho, int largo) {
        this.ancho = ancho;
        this.largo = largo;
    }

    public void avanzarNPosicionesGladiador(Gladiador gladiador, int posicionesCantidad) {
        ICelda celdaActual = posicionDeGladiadores.get(gladiador);
        ICelda celdaDestino = this.camino.proximoEnNPosiciones(celdaActual, posicionesCantidad);
        try {
            // TODO Avanzar podria mandarle la concecuencia
            gladiador.avanzar();
            this.posicionDeGladiadores.put(gladiador, celdaDestino);
            celdaDestino.afectarGladiadorConConsecuencia(gladiador);
        } catch (MovimientoPausadoExeption | MovimientoException e) {
            throw new RuntimeException(e);
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
        try {
            // TODO al retroceder recibe la concecuencia de la celda?
//            gladiador.avanzar();
            this.posicionDeGladiadores.put(gladiador, celdaDestino);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ICelda getPosicionDeGladiador(Gladiador gladiador) {
        return posicionDeGladiadores.get(gladiador);
    }

    public void setCamino(Camino camino) {
        this.camino = camino;
    }

    public int getAncho() {
        return ancho;
    }

    public int getLargo() {
        return largo;
    }
}
