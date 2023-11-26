package edu.fiuba.algo3.modelo.json_parsing.DAOs;

import edu.fiuba.algo3.modelo.json_parsing.DTOs.CaminoDto;

import java.util.List;

public interface CaminoDao extends GenericDao<CaminoDto> {
    CaminoDto obtener();
}
