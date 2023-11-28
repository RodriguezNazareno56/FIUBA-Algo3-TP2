package edu.fiuba.algo3.json_parsing;

import edu.fiuba.algo3.json_parsing.data_mappers.CaminoMapper;
import edu.fiuba.algo3.json_parsing.data_mappers.CeldaMapper;
import edu.fiuba.algo3.json_parsing.data_mappers.MapaMapper;
import edu.fiuba.algo3.json_parsing.repositories.CaminoRepositoryImpl;
import edu.fiuba.algo3.json_parsing.DAOs.CaminoDAOJsonImpl;
import edu.fiuba.algo3.json_parsing.DAOs.MapaDAOJsonImpl;
import edu.fiuba.algo3.json_parsing.repositories.CaminoRepository;
import edu.fiuba.algo3.json_parsing.repositories.MapaRepository;
import edu.fiuba.algo3.json_parsing.repositories.MapaRepositoryImpl;
import edu.fiuba.algo3.modelo.camino.Camino;
import edu.fiuba.algo3.modelo.mapa.Mapa;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonMapper {

    public static void main(String[] args) throws IOException {
        Path jsonPath = Paths.get("src/main/java/edu/fiuba/algo3/json_parsing/mapa.json");
        try {
            CaminoRepository caminoRepository = new CaminoRepositoryImpl(
                    new CaminoDAOJsonImpl(jsonPath),
                    new CaminoMapper(new CeldaMapper()));
            Camino camino = caminoRepository.obtener();

            MapaRepository mapaRepository = new MapaRepositoryImpl(
                    new MapaDAOJsonImpl(jsonPath),
                    new MapaMapper());
            Mapa mapa = mapaRepository.obtener();

            mapa.setCamino(camino);

            // Accede a los datos del mapa
            System.out.println(mapa);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
