package edu.fiuba.algo3.modelo.json_parsing;

import edu.fiuba.algo3.modelo.json_parsing.DAOs.CaminoDao;
import edu.fiuba.algo3.modelo.json_parsing.DAOs.CaminoDaoJsonImpl;
import edu.fiuba.algo3.modelo.json_parsing.DAOs.MapaDao;
import edu.fiuba.algo3.modelo.json_parsing.DAOs.MapaDaoJsonImp;
import edu.fiuba.algo3.modelo.json_parsing.DTOs.CaminoDto;
import edu.fiuba.algo3.modelo.json_parsing.DTOs.CeldaDto;
import edu.fiuba.algo3.modelo.json_parsing.DTOs.MapaDto;

import java.io.IOException;

public class JsonMapper {

    public static void main(String[] args) throws IOException {
        try {
            CaminoDao caminoDao = new CaminoDaoJsonImpl();
            CaminoDto caminoDto = caminoDao.obtener();

            MapaDao mapaDao = new MapaDaoJsonImp();
            MapaDto mapaDto =mapaDao.obtener();

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
