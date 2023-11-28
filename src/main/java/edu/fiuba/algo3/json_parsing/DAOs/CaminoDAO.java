package edu.fiuba.algo3.json_parsing.DAOs;

import edu.fiuba.algo3.json_parsing.DTOs.CaminoDto;
import edu.fiuba.algo3.json_parsing.data_mappers.JsonFormatoInvalidoException;

public interface CaminoDAO extends DAO<CaminoDto> {
    CaminoDto obtener() throws JsonFormatoInvalidoException;
}
