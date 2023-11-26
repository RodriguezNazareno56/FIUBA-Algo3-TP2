package edu.fiuba.algo3.modelo.json_parsing.repositories;

import edu.fiuba.algo3.modelo.json_parsing.DTOs.CaminoDto;

public interface CaminoRepository extends Repository<CaminoDto> {
    CaminoDto obtener();
}
