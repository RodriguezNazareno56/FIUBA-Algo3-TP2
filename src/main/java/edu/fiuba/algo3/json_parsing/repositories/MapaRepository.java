package edu.fiuba.algo3.json_parsing.repositories;

import edu.fiuba.algo3.modelo.mapa.Mapa;

public interface MapaRepository extends Repository<Mapa> {
    Mapa obtener();
}
