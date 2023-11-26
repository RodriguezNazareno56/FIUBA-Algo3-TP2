package edu.fiuba.algo3.modelo.json_parsing.DAOs;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.modelo.json_parsing.DTOs.CaminoDto;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CaminoDaoJsonImpl implements CaminoDao {
    @Override
    public CaminoDto obtener() {
        try {
            // Obtén la ruta relativa al directorio de trabajo
            Path path = Paths.get("src/main/java/edu/fiuba/algo3/modelo/json_parsing/mapa.json");

            // Lee el contenido del archivo JSON
            String jsonString = new String(Files.readAllBytes(path));

            // Manipular el json para obtener el objeto camino
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONObject jsonObjectCamino = jsonObject.getJSONObject("camino");

            // Deserializar el objeto camino del JSON a la clase CaminoDto
            ObjectMapper objectMapper = new ObjectMapper();
            CaminoDto camino = objectMapper.readValue(jsonObjectCamino.toString(), CaminoDto.class);
            return camino;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}