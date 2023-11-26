package edu.fiuba.algo3.modelo.json_parsing.repositories;

import edu.fiuba.algo3.modelo.json_parsing.DAOs.CaminoDAO;
import edu.fiuba.algo3.modelo.json_parsing.DTOs.CaminoDto;

public class CaminoRepositoryImpl implements CaminoRepository {

    private final CaminoDAO caminoDAO;

    public CaminoRepositoryImpl(CaminoDAO caminoDAO) {
        this.caminoDAO = caminoDAO;
    }

    @Override
    public CaminoDto obtener() {
        CaminoDto camino = this.caminoDAO.obtener();
        // Deberia retorna un camino no un DTO
        return camino;
    }
}