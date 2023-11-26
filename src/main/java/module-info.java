module edu.fiuba.algo3 {
    requires javafx.controls;
    requires com.fasterxml.jackson.databind;
    requires org.json;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.modelo;
    exports edu.fiuba.algo3.modelo.gladiador.senority;
    exports edu.fiuba.algo3.modelo.consecuencias;
    exports edu.fiuba.algo3.modelo.gladiador;
    exports edu.fiuba.algo3.modelo.casilleros;
    exports edu.fiuba.algo3.modelo.equipamientos;
    exports edu.fiuba.algo3.modelo.gladiador.senority.states;
    exports edu.fiuba.algo3.modelo.json_parsing;
    exports edu.fiuba.algo3.modelo.json_parsing.repositories;
    exports edu.fiuba.algo3.modelo.json_parsing.DTOs;
    exports edu.fiuba.algo3.modelo.celda;
}