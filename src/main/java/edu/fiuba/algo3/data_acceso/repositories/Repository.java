package edu.fiuba.algo3.data_acceso.repositories;

import edu.fiuba.algo3.data_acceso.data_mappers.JsonFormatoInvalidoException;

public interface Repository<T> {
    T obtener() throws JsonFormatoInvalidoException;
}
