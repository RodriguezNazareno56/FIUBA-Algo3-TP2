package edu.fiuba.algo3.modelo.json_parsing.repositories;

import edu.fiuba.algo3.modelo.json_parsing.DTOs.MapaDto;

public interface MapaRepository extends Repository<MapaDto> {
    MapaDto obtener();
}
