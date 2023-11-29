package edu.fiuba.algo3.data_acceso.repositories;

import edu.fiuba.algo3.data_acceso.data_mappers.JsonFormatoInvalidoException;
import edu.fiuba.algo3.modelo.mapa.Mapa;

public interface MapaRepository extends Repository<Mapa> {
    Mapa obtener() throws JsonFormatoInvalidoException;
}
