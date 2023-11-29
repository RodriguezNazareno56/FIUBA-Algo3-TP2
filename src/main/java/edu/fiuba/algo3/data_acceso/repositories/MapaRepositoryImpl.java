package edu.fiuba.algo3.data_acceso.repositories;

import edu.fiuba.algo3.data_acceso.DTOs.MapaDto;
import edu.fiuba.algo3.data_acceso.DAOs.MapaDAO;
import edu.fiuba.algo3.data_acceso.data_mappers.JsonFormatoInvalidoException;
import edu.fiuba.algo3.data_acceso.data_mappers.MapaMapper;
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
