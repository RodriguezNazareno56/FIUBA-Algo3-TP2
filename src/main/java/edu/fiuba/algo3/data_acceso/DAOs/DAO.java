package edu.fiuba.algo3.data_acceso.DAOs;

import edu.fiuba.algo3.data_acceso.data_mappers.JsonFormatoInvalidoException;

public interface DAO<T> {
    T obtener() throws JsonFormatoInvalidoException;
}
