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
import edu.fiuba.algo3.json_parsing.DTOs.MapaDto;
import edu.fiuba.algo3.modelo.camino.Camino;
import edu.fiuba.algo3.modelo.celda.ICelda;
import edu.fiuba.algo3.modelo.mapa.Mapa;

import java.io.IOException;

public class JsonMapper {

    public static void main(String[] args) throws IOException {
        try {
            CaminoRepository caminoRepository = new CaminoRepositoryImpl(
                    new CaminoDAOJsonImpl(),
                    new CaminoMapper(new CeldaMapper()));
            Camino camino = caminoRepository.obtener();

            MapaRepository mapaRepository = new MapaRepositoryImpl(
                    new MapaDAOJsonImpl(),
                    new MapaMapper());
            Mapa mapa = mapaRepository.obtener();

            // Accede a los datos del mapa
            System.out.println("Ancho del mapa: " + mapa.getAncho());
            System.out.println("Largo del mapa: " + mapa.getLargo());

            // Accede a los datos del camino
            System.out.println("Celdas del camino:");
            for (ICelda celda : camino.getCeldas()) {
                System.out.println(celda);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
