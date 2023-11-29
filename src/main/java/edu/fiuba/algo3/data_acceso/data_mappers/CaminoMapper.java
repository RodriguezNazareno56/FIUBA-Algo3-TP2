package edu.fiuba.algo3.data_acceso.data_mappers;

import edu.fiuba.algo3.data_acceso.DTOs.CaminoDto;
import edu.fiuba.algo3.data_acceso.DTOs.CeldaDto;
import edu.fiuba.algo3.modelo.camino.Camino;
import edu.fiuba.algo3.modelo.celda.ICelda;

import java.util.ArrayList;
import java.util.List;

public class CaminoMapper implements Mapper<Camino, CaminoDto> {

    private CeldaMapper celdaMapper;

    public CaminoMapper(CeldaMapper celdaMapper) {
        this.celdaMapper = celdaMapper;
    }

    public Camino convertirDesdeDto(CaminoDto caminoDto) throws JsonFormatoInvalidoException {
        List<ICelda> celdas = new ArrayList<>();
        for (CeldaDto celdaDto : caminoDto.getCeldas()) {
            celdas.add(this.celdaMapper.convertirDesdeDto(celdaDto));
        }
        return new Camino(celdas);
    }
}
