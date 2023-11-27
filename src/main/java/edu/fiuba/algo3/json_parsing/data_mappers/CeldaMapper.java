package edu.fiuba.algo3.json_parsing.data_mappers;

import edu.fiuba.algo3.json_parsing.DTOs.CeldaDto;
import edu.fiuba.algo3.modelo.celda.*;
import edu.fiuba.algo3.modelo.consecuencias.*;

import java.util.ArrayList;
import java.util.List;

public class CeldaMapper implements Mapper<ICelda, CeldaDto>{

    public ICelda convertirDesdeDto(CeldaDto celdaDto) throws Exception {
        List<Consecuencia> consecuencias = new ArrayList<>();
        switch (celdaDto.getObstaculo()) {
            case "Lesion":
                consecuencias.add(new Lesion());
                break;
            case "Fiera":
                consecuencias.add(new FieraSalvaje());
                break;
            case "Bacanal":
                // La cantidad de tragos no debe ser definida en la inicializacion sino en el momento que el juegador
                // arroja el dado y conoce cuantos tragos debe tomar.
//                consecuencias.add(new AsisteAUnBacanal());
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
        switch (celdaDto.getTipo()) {
            case "Salida":
                celda = new CeldaSalida(celdaDto.getX(), celdaDto.getY(), consecuencias);
                return celda;
            case "Camino":
                celda = new CeldaCamino(celdaDto.getX(), celdaDto.getY(), consecuencias);
                return celda;
            case "Llegada":
                celda = new CeldaLlegada(celdaDto.getX(), celdaDto.getY(), consecuencias);
                return celda;
        }
        // Una exepcion de formato invalido
        throw new Exception();
    }
}
