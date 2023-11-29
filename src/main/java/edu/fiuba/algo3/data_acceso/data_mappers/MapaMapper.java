package edu.fiuba.algo3.data_acceso.data_mappers;

import edu.fiuba.algo3.data_acceso.DTOs.MapaDto;
import edu.fiuba.algo3.modelo.mapa.Mapa;

public class MapaMapper implements Mapper<Mapa, MapaDto>{

    @Override
    public Mapa convertirDesdeDto(MapaDto mapaDto) {
        return new Mapa(mapaDto.getAncho(), mapaDto.getLargo());
    }
}
