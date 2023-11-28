package edu.fiuba.algo3.json_parsing.DAOs;

import edu.fiuba.algo3.json_parsing.data_mappers.JsonFormatoInvalidoException;

public interface DAO<T> {
    T obtener() throws JsonFormatoInvalidoException;
}
