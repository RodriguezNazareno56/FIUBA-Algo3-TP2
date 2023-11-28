package edu.fiuba.algo3.json_parsing.DAOs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.json_parsing.DTOs.MapaDto;
import edu.fiuba.algo3.json_parsing.data_mappers.JsonFormatoInvalidoException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MapaDAOJsonImpl implements MapaDAO {

    private String jsonString;

    public MapaDAOJsonImpl(String jsonString) {
        this.jsonString = jsonString;
    }

    public MapaDAOJsonImpl(Path jsonPath) throws IOException {
        // Lee el contenido del archivo JSON
        this.jsonString = new String(Files.readAllBytes(jsonPath));
    }

    @Override
    public MapaDto obtener() throws JsonFormatoInvalidoException {
        // Manipular el json para obtener el objeto mapa
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONObject jsonObjectMap = jsonObject.getJSONObject("mapa");
        // Deserializar el objeto mapa del JSON a la clase MapaDto
        ObjectMapper objectMapper = new ObjectMapper();
        MapaDto mapa = null;
        try {
            mapa = objectMapper.readValue(jsonObjectMap.toString(), MapaDto.class);
        } catch (JsonProcessingException e) {
            throw new JsonFormatoInvalidoException(e.getMessage());
        }
        return mapa;
    }
}
