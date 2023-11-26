package edu.fiuba.algo3.modelo.json_parsing.DAOs;

import edu.fiuba.algo3.modelo.json_parsing.DTOs.MapaDto;

import java.util.List;

public interface MapaDao extends GenericDao<MapaDto> {
    MapaDto obtener();
}
