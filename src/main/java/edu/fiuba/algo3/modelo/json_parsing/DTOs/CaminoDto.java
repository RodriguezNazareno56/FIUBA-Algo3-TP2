package edu.fiuba.algo3.modelo.json_parsing.DTOs;

import java.util.Arrays;
import java.util.List;

public class CaminoDto {
    private List<CeldaDto> celdas;

    public CaminoDto() {
    }

    public List<CeldaDto> getCeldas() {
        return celdas;
    }

    public void setCeldas(List<CeldaDto> celdaDtos) {
        this.celdas = celdaDtos;
    }

    @Override
    public String toString() {
        return "Camino{" +
                "celdas=" + Arrays.toString(getCeldas().toArray()) +
                '}';
    }
}
