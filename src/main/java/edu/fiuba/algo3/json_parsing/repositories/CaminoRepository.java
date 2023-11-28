package edu.fiuba.algo3.json_parsing.repositories;

import edu.fiuba.algo3.json_parsing.data_mappers.JsonFormatoInvalidoException;
import edu.fiuba.algo3.modelo.camino.Camino;

public interface CaminoRepository extends Repository<Camino> {
    Camino obtener() throws JsonFormatoInvalidoException;
}
