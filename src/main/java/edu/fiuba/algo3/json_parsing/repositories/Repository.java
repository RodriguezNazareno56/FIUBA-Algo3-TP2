package edu.fiuba.algo3.json_parsing.repositories;

import edu.fiuba.algo3.json_parsing.data_mappers.JsonFormatoInvalidoException;

public interface Repository<T> {
    T obtener() throws JsonFormatoInvalidoException;
}
