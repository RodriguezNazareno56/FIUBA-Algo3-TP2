package edu.fiuba.algo3.modelo.json_parsing;

import edu.fiuba.algo3.modelo.json_parsing.DAOs.CaminoDAOJsonImpl;
import edu.fiuba.algo3.modelo.json_parsing.DAOs.MapaDAOJsonImpl;
import edu.fiuba.algo3.modelo.json_parsing.repositories.CaminoRepository;
import edu.fiuba.algo3.modelo.json_parsing.repositories.CaminoRepositoryImpl;
import edu.fiuba.algo3.modelo.json_parsing.repositories.MapaRepository;
import edu.fiuba.algo3.modelo.json_parsing.repositories.MapaRepositoryImpl;
import edu.fiuba.algo3.modelo.json_parsing.DTOs.CaminoDto;
import edu.fiuba.algo3.modelo.json_parsing.DTOs.CeldaDto;
import edu.fiuba.algo3.modelo.json_parsing.DTOs.MapaDto;

import java.io.IOException;

public class JsonMapper {

    public static void main(String[] args) throws IOException {
        try {
            CaminoRepository caminoRepository = new CaminoRepositoryImpl(new CaminoDAOJsonImpl());
            CaminoDto caminoDto = caminoRepository.obtener();

            MapaRepository mapaRepository = new MapaRepositoryImpl(new MapaDAOJsonImpl());
            MapaDto mapaDto = mapaRepository.obtener();

            // Accede a los datos del mapa
            System.out.println("Ancho del mapa: " + mapaDto.getAncho());
            System.out.println("Largo del mapa: " + mapaDto.getLargo());

            // Accede a los datos del camino
            System.out.println("Celdas del camino:");
            for (CeldaDto celda : caminoDto.getCeldas()) {
                System.out.println(celda);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
