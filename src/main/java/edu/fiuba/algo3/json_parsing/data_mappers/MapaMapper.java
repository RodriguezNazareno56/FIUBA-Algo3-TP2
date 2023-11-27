package edu.fiuba.algo3.json_parsing.data_mappers;

import edu.fiuba.algo3.json_parsing.DTOs.MapaDto;
import edu.fiuba.algo3.modelo.mapa.Mapa;

public class MapaMapper implements Mapper<Mapa, MapaDto>{

    @Override
    public Mapa convertirDesdeDto(MapaDto mapaDto) {
        return new Mapa(mapaDto.getAncho(), mapaDto.getLargo());
    }
}
