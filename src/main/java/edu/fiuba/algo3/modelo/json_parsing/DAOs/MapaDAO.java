package edu.fiuba.algo3.modelo.json_parsing.DAOs;

import edu.fiuba.algo3.modelo.json_parsing.DTOs.MapaDto;

public interface MapaDAO extends DAO<MapaDto>{
    MapaDto obtener();
}
