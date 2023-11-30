package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.data_acceso.DAOs.MapaDAOJsonImpl;
import edu.fiuba.algo3.data_acceso.data_mappers.JsonFormatoInvalidoException;
import edu.fiuba.algo3.data_acceso.data_mappers.MapaMapper;
import edu.fiuba.algo3.data_acceso.repositories.MapaRepository;
import edu.fiuba.algo3.data_acceso.repositories.MapaRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CasoDeUso13Test {

    Path jsonConMapaInvalidoPath = Paths.get("src/main/test/edu/fiuba/algo3/entrega_2/Json_test_resources/CasoDeUso13.json");

    @Test
    public void verificarFormatoValidoJsonMapa() throws Exception {
        // TODO: supuesto: consideramos JsonMapa a la parte del json que contiene el jsonObject mapa
        //  "mapa": {
        //    "ancho": 10,
        //    "largo": 18
        //  },

        // Arrange
        // instancio un mapaRepository con un json con formato invalido
        MapaRepository mapaRepository = new MapaRepositoryImpl(
                new MapaDAOJsonImpl(jsonConMapaInvalidoPath),
                new MapaMapper());
        // Assert
        Assertions.assertThrows(JsonFormatoInvalidoException.class, mapaRepository::obtener);
    }
}
