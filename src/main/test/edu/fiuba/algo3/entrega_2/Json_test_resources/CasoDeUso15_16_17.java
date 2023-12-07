package edu.fiuba.algo3.entrega_2.Json_test_resources;

import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.camino.Camino;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.celda.Coordenada;
import edu.fiuba.algo3.modelo.celda.ICelda;
import edu.fiuba.algo3.modelo.consecuencias.*;

import java.util.ArrayList;
import java.util.List;

public class CasoDeUso15_16_17 {

    /**
     * Se construye manualmente un camino como se describe en el CasoDeUso15_16_17.json con todas sus entidades a
     * finalidad de testear
     */
    public static Camino obtenerCaminoHardcodeado() {
        // Creo las celdas de acuerdo al json
        List<ICelda> celdas = new ArrayList<>();

        // Celda 1
        Coordenada coordenada1 = new Coordenada(1, 7);
        List<IConsecuencia> consecuencias1 = new ArrayList<>();
        ICelda celda1 = new Celda(coordenada1, consecuencias1);
        celdas.add(celda1);

        // Celda2
        Coordenada coordenada2 = new Coordenada(2, 7);
        List<IConsecuencia> consecuencias2 = new ArrayList<>();
        consecuencias2.add(new EquipamientoIncrementado());
        ICelda celda2 = new Celda(coordenada2, consecuencias2);
        celdas.add(celda2);

        // Celda3
        Coordenada coordenada3 = new Coordenada(3, 7);
        List<IConsecuencia> consecuencias3 = new ArrayList<>();
        consecuencias3.add(new Comida());
        ICelda celda3 = new Celda(coordenada3, consecuencias3);
        celdas.add(celda3);

        // Celda4
        Coordenada coordenada4 = new Coordenada(4, 7);
        List<IConsecuencia> consecuencias4 = new ArrayList<>();
        consecuencias4.add(new Lesion());
        ICelda celda4 = new Celda(coordenada4, consecuencias4);
        celdas.add(celda4);

        // Celda5
        Coordenada coordenada5 = new Coordenada(5, 7);
        List<IConsecuencia> consecuencias5 = new ArrayList<>();
        consecuencias5.add(new FieraSalvaje());
        ICelda celda5 = new Celda(coordenada5, consecuencias5);
        celdas.add(celda5);

        // Celda6
        Coordenada coordenada6 = new Coordenada(6, 7);
        List<IConsecuencia> consecuencias6 = new ArrayList<>();
        Dado dado = new Dado();
        consecuencias6.add(new AsisteAUnBacanal(dado));
        ICelda celda6 = new Celda(coordenada6, consecuencias6);
        celdas.add(celda6);

        // Celda7
        Coordenada coordenada7 = new Coordenada(7, 7);
        List<IConsecuencia> consecuencias7 = new ArrayList<>();
        consecuencias7.add(new Lesion());
        consecuencias7.add(new Comida());
        ICelda celda7 = new Celda(coordenada7, consecuencias7);
        celdas.add(celda7);

        // Celda8
        Coordenada coordenada8 = new Coordenada(8, 7);
        List<IConsecuencia> consecuencias8 = new ArrayList<>();
        consecuencias8.add(new Triunfo());
        ICelda celda8 = new Celda(coordenada8, consecuencias8);
        celdas.add(celda8);

        return new Camino(celdas);
    }
}
