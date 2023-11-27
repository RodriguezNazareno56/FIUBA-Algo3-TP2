package edu.fiuba.algo3.json_parsing.DAOs;

import edu.fiuba.algo3.json_parsing.DTOs.MapaDto;

public interface MapaDAO extends DAO<MapaDto>{
    MapaDto obtener();
}
