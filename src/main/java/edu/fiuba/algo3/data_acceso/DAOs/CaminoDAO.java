package edu.fiuba.algo3.data_acceso.DAOs;

import edu.fiuba.algo3.data_acceso.DTOs.CaminoDto;
import edu.fiuba.algo3.data_acceso.data_mappers.JsonFormatoInvalidoException;

public interface CaminoDAO extends DAO<CaminoDto> {
    CaminoDto obtener() throws JsonFormatoInvalidoException;
}
