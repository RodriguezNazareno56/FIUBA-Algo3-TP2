package edu.fiuba.algo3.json_parsing.data_mappers;

import edu.fiuba.algo3.json_parsing.DTOs.CaminoDto;
import edu.fiuba.algo3.modelo.camino.Camino;
import edu.fiuba.algo3.modelo.celda.ICelda;

import java.util.ArrayList;
import java.util.List;

public class CaminoMapper implements Mapper<Camino, CaminoDto> {

    private CeldaMapper celdaMapper;

    public CaminoMapper(CeldaMapper celdaMapper) {
        this.celdaMapper = celdaMapper;
    }

    public Camino convertirDesdeDto(CaminoDto caminoDto) {
        List<ICelda> celdas = new ArrayList<>();
        caminoDto.getCeldas().forEach(celdaDto -> {
            try {
                celdas.add(this.celdaMapper.convertirDesdeDto(celdaDto));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return new Camino(celdas);
    }
}
