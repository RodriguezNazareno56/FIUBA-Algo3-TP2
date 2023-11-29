package edu.fiuba.algo3.data_acceso.DAOs;

import edu.fiuba.algo3.data_acceso.DTOs.MapaDto;
import edu.fiuba.algo3.data_acceso.data_mappers.JsonFormatoInvalidoException;

public interface MapaDAO extends DAO<MapaDto>{
    MapaDto obtener() throws JsonFormatoInvalidoException;
}
