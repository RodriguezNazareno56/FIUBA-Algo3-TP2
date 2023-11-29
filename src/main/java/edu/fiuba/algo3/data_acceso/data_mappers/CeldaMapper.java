package edu.fiuba.algo3.data_acceso.data_mappers;

import edu.fiuba.algo3.data_acceso.DTOs.CeldaDto;
import edu.fiuba.algo3.modelo.celda.*;
import edu.fiuba.algo3.modelo.consecuencias.*;

import java.util.ArrayList;
import java.util.List;

public class CeldaMapper implements Mapper<ICelda, CeldaDto>{

    public ICelda convertirDesdeDto(CeldaDto celdaDto) throws JsonFormatoInvalidoException {
        List<Consecuencia> consecuencias = new ArrayList<>();
        switch (celdaDto.getObstaculo()) {
            case "Lesion":
                consecuencias.add(new Lesion());
                break;
            case "Fiera":
                consecuencias.add(new FieraSalvaje());
                break;
            case "Bacanal":
//              TODO: La cantidad de tragos no debe ser definida en la inicializacion sino en el momento que el juegador
//               arroja el dado y conoce cuantos tragos debe tomar.
                consecuencias.add(new AsisteAUnBacanal(1));
                break;
        }
        switch (celdaDto.getPremio()) {
            case "Equipamiento":
                consecuencias.add(new EquipamientoIncrementado());
                break;
            case "Comida":
                consecuencias.add(new Comida());
                break;
        }
        ICelda celda;
        Coordenada coordenada = new Coordenada(celdaDto.getX(), celdaDto.getY());
        switch (celdaDto.getTipo()) {
            case "Salida":
            case "Camino":
                celda = new Celda(coordenada, consecuencias);
                return celda;
            case "Llegada":
                consecuencias.add(new Triunfo());
                celda = new Celda(coordenada, consecuencias);
                return celda;
            default:
                throw new JsonFormatoInvalidoException("Formato de la celda invalido");
        }
    }
}
