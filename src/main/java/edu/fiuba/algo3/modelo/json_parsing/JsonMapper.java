package edu.fiuba.algo3.modelo.json_parsing;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonMapper {

    public static void main(String[] args) throws IOException {
        try {
            // Obtén la ruta relativa al directorio de trabajo
            Path path = Paths.get("src/main/java/edu/fiuba/algo3/modelo/json_parsing/mapa.json");

            // Lee el contenido del archivo JSON
            String jsonString = new String(Files.readAllBytes(path));

            // Deserializa el JSON a la clase Mapa
            ObjectMapper objectMapper = new ObjectMapper();
            Juego juego = objectMapper.readValue(jsonString, Juego.class);

            // Accede a los datos del mapa
            System.out.println("Ancho del mapa: " + juego.getMapa().getAncho());
            System.out.println("Largo del mapa: " + juego.getMapa().getLargo());

            // Accede a los datos del camino
            Camino camino = juego.getCamino();
            System.out.println("Celdas del camino:");
            for (Celda celda : camino.getCeldas()) {
                System.out.println(celda);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
