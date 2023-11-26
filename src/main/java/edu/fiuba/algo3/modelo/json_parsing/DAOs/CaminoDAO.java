package edu.fiuba.algo3.modelo.json_parsing.DAOs;

import edu.fiuba.algo3.modelo.json_parsing.DTOs.CaminoDto;

public interface CaminoDAO extends DAO<CaminoDto> {
    CaminoDto obtener();
}
