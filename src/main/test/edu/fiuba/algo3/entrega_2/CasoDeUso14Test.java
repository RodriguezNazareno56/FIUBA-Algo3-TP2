package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.data_acceso.DAOs.MapaDAOJsonImpl;
import edu.fiuba.algo3.data_acceso.data_mappers.JsonFormatoInvalidoException;
import edu.fiuba.algo3.data_acceso.data_mappers.MapaMapper;
import edu.fiuba.algo3.data_acceso.repositories.MapaRepository;
import edu.fiuba.algo3.data_acceso.repositories.MapaRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CasoDeUso14Test {

    Path jsonConMapaInvalidoPath = Paths.get("src/main/test/edu/fiuba/algo3/entrega_2/Json_test_resources/CasoDeUso14.json");

    @Test
    public void verificarFormatoValidoJsonMapa() throws IOException {
        MapaRepository mapaRepository = new MapaRepositoryImpl(
                new MapaDAOJsonImpl(jsonConMapaInvalidoPath),
                new MapaMapper());
        Assertions.assertThrows(JsonFormatoInvalidoException.class, mapaRepository::obtener);
    }
}
