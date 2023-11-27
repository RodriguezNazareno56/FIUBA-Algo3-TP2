package edu.fiuba.algo3.json_parsing.DAOs;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.json_parsing.DTOs.MapaDto;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MapaDAOJsonImpl implements MapaDAO {
    @Override
    public MapaDto obtener() {
        try {
            // Obtén la ruta relativa al directorio de trabajo
            Path path = Paths.get("src/main/java/edu/fiuba/algo3/json_parsing/mapa.json");

            // Lee el contenido del archivo JSON
            String jsonString = new String(Files.readAllBytes(path));

            // Manipular el json para obtener el objeto mapa
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONObject jsonObjectMap = jsonObject.getJSONObject("mapa");

            // Deserializar el objeto mapa del JSON a la clase MapaDto
            ObjectMapper objectMapper = new ObjectMapper();
            MapaDto mapa = objectMapper.readValue(jsonObjectMap.toString(), MapaDto.class);
            return mapa;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
