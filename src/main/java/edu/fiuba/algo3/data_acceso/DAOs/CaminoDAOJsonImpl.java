package edu.fiuba.algo3.data_acceso.DAOs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.data_acceso.DTOs.CaminoDto;
import edu.fiuba.algo3.data_acceso.data_mappers.JsonFormatoInvalidoException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CaminoDAOJsonImpl implements CaminoDAO {

    private String jsonString;

    public CaminoDAOJsonImpl(String jsonString) {
        this.jsonString = jsonString;
    }

    public CaminoDAOJsonImpl(Path jsonPath) throws IOException {
        this.jsonString = new String(Files.readAllBytes(jsonPath));
    }

    @Override
    public CaminoDto obtener() throws JsonFormatoInvalidoException {
        // Manipular el json para obtener el objeto camino
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONObject jsonObjectCamino = jsonObject.getJSONObject("camino");

        // Deserializar el objeto camino del JSON a la clase CaminoDto
        ObjectMapper objectMapper = new ObjectMapper();
        CaminoDto caminoDto;
        try {
            caminoDto = objectMapper.readValue(jsonObjectCamino.toString(), CaminoDto.class);
        } catch (JsonProcessingException e) {
            throw new JsonFormatoInvalidoException(e.getMessage());
        }
        return caminoDto;
    }
}
