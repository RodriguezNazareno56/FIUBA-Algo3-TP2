package edu.fiuba.algo3.data_acceso.repositories;

import edu.fiuba.algo3.data_acceso.data_mappers.JsonFormatoInvalidoException;
import edu.fiuba.algo3.modelo.camino.Camino;

public interface CaminoRepository extends Repository<Camino> {
    Camino obtener() throws JsonFormatoInvalidoException;
}
