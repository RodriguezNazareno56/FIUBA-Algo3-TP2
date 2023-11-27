package edu.fiuba.algo3.json_parsing.repositories;

import edu.fiuba.algo3.json_parsing.DTOs.CaminoDto;
import edu.fiuba.algo3.json_parsing.DAOs.CaminoDAO;
import edu.fiuba.algo3.json_parsing.data_mappers.CaminoMapper;
import edu.fiuba.algo3.modelo.camino.Camino;

public class CaminoRepositoryImpl implements CaminoRepository {

    private final CaminoDAO caminoDAO;
    private final CaminoMapper caminoMapper;

    public CaminoRepositoryImpl(CaminoDAO caminoDAO, CaminoMapper caminoMapper) {
        this.caminoDAO = caminoDAO;
        this.caminoMapper = caminoMapper;
    }

    @Override
    public Camino obtener() {
        CaminoDto caminoDto = this.caminoDAO.obtener();
        // Deberia retorna un camino no un DTO
        return this.caminoMapper.convertirDesdeDto(caminoDto);
    }
}