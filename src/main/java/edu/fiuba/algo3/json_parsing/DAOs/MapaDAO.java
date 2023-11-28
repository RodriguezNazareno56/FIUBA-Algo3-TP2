package edu.fiuba.algo3.json_parsing.DAOs;

import edu.fiuba.algo3.json_parsing.DTOs.MapaDto;
import edu.fiuba.algo3.json_parsing.data_mappers.JsonFormatoInvalidoException;

public interface MapaDAO extends DAO<MapaDto>{
    MapaDto obtener() throws JsonFormatoInvalidoException;
}
