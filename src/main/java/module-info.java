module edu.fiuba.algo3 {
    requires javafx.controls;
    requires com.fasterxml.jackson.databind;
    requires org.json;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.modelo;
    exports edu.fiuba.algo3.modelo.gladiador.senority;
    exports edu.fiuba.algo3.modelo.consecuencias;
    exports edu.fiuba.algo3.modelo.gladiador;
    exports edu.fiuba.algo3.modelo.equipamientos;
    exports edu.fiuba.algo3.modelo.gladiador.senority.states;
    exports edu.fiuba.algo3.modelo.celda;
    exports edu.fiuba.algo3.modelo.camino;
    exports edu.fiuba.algo3.modelo.mapa;
    exports edu.fiuba.algo3.json_parsing;
    exports edu.fiuba.algo3.json_parsing.repositories;
    exports edu.fiuba.algo3.json_parsing.DTOs;
    exports edu.fiuba.algo3.json_parsing.DAOs;
    exports edu.fiuba.algo3.json_parsing.data_mappers;
}