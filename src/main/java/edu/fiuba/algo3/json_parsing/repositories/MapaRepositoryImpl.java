package edu.fiuba.algo3.json_parsing.repositories;

import edu.fiuba.algo3.json_parsing.DTOs.MapaDto;
import edu.fiuba.algo3.json_parsing.DAOs.MapaDAO;
import edu.fiuba.algo3.json_parsing.data_mappers.JsonFormatoInvalidoException;
import edu.fiuba.algo3.json_parsing.data_mappers.MapaMapper;
import edu.fiuba.algo3.modelo.mapa.Mapa;

public class MapaRepositoryImpl implements MapaRepository {

    private final MapaDAO mapaDAO;
    private final MapaMapper mapaMapper;

    public MapaRepositoryImpl(MapaDAO mapaDAO, MapaMapper mapaMapper) {
        this.mapaDAO = mapaDAO;
        this.mapaMapper = mapaMapper;
    }

    @Override
    public Mapa obtener() throws JsonFormatoInvalidoException {
        MapaDto mapaDto = this.mapaDAO.obtener();
        return this.mapaMapper.convertirDesdeDto(mapaDto);
    }
}
