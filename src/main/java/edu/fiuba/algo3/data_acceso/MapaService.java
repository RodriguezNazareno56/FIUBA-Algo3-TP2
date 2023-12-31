package edu.fiuba.algo3.data_acceso;

import edu.fiuba.algo3.data_acceso.data_mappers.JsonFormatoInvalidoException;
import edu.fiuba.algo3.data_acceso.repositories.CaminoRepository;
import edu.fiuba.algo3.data_acceso.repositories.MapaRepository;
import edu.fiuba.algo3.modelo.camino.Camino;
import edu.fiuba.algo3.modelo.mapa.Mapa;

public class MapaService {

    private CaminoRepository caminoRepository;
    private MapaRepository mapaRepository;

    public MapaService(CaminoRepository caminoRepository, MapaRepository mapaRepository) {
        this.caminoRepository = caminoRepository;
        this.mapaRepository = mapaRepository;
    }

    public Mapa cargarMapa() throws JsonFormatoInvalidoException {
        Camino camino = this.caminoRepository.obtener();
        Mapa mapa = this.mapaRepository.obtener();
        mapa.setCamino(camino);
        return mapa;
    }
}
