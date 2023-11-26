package edu.fiuba.algo3.modelo.json_parsing.repositories;

import edu.fiuba.algo3.modelo.json_parsing.DAOs.MapaDAO;
import edu.fiuba.algo3.modelo.json_parsing.DTOs.MapaDto;

public class MapaRepositoryImpl implements MapaRepository {

    private final MapaDAO mapaDAO;

    public MapaRepositoryImpl(MapaDAO mapaDAO) {
        this.mapaDAO = mapaDAO;
    }
    @Override
    public MapaDto obtener() {
        MapaDto mapaDto = this.mapaDAO.obtener();
        // Deberia retorna un mapa no un DTO
        return mapaDto;
    }
}
