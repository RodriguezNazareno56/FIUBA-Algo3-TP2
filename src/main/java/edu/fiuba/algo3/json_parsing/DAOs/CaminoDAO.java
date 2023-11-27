package edu.fiuba.algo3.json_parsing.DAOs;

import edu.fiuba.algo3.json_parsing.DTOs.CaminoDto;

public interface CaminoDAO extends DAO<CaminoDto> {
    CaminoDto obtener();
}
