package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.data_acceso.DAOs.CaminoDAOJsonImpl;
import edu.fiuba.algo3.data_acceso.data_mappers.CaminoMapper;
import edu.fiuba.algo3.data_acceso.data_mappers.CeldaMapper;
import edu.fiuba.algo3.data_acceso.data_mappers.JsonFormatoInvalidoException;
import edu.fiuba.algo3.data_acceso.repositories.CaminoRepository;
import edu.fiuba.algo3.data_acceso.repositories.CaminoRepositoryImpl;
import edu.fiuba.algo3.modelo.dado.Dado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso14Test {

    Path jsonConCaminoInvalidoPath = Paths.get("src/main/test/edu/fiuba/algo3/entrega_2/Json_test_resources/CasoDeUso14.json");

    @Test
    public void verificarFormatoValidoJsonObstaculosYPremios() throws IOException {
        // TODO: supuesto: consideramos JsonObstaculosYPremios a la parte del json que contiene el camino
        //  "camino": {
        //    "celdas": [
        //      {
        //        "x": 1,
        //        "y": 7,
        //        "tipo": "Salida",
        //        "obstaculo": "",
        //        "premio": ""
        //      },...

        // Arrange
        // instancio un caminoRepository con un json con formato invalido
        CaminoRepository caminoRepository = new CaminoRepositoryImpl(
                new CaminoDAOJsonImpl(jsonConCaminoInvalidoPath),
                new CaminoMapper(new CeldaMapper(new Dado())));

        // Assert
        Assertions.assertThrows(JsonFormatoInvalidoException.class, caminoRepository::obtener);
    }
}
