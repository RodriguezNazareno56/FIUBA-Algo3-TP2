module edu.fiuba.algo3 {
    requires javafx.controls;
    requires com.fasterxml.jackson.databind;
    requires org.json;
    requires org.slf4j;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.modelo;
    exports edu.fiuba.algo3.modelo.gladiador.senority;
    exports edu.fiuba.algo3.modelo.consecuencias;
    exports edu.fiuba.algo3.modelo.gladiador;
    exports edu.fiuba.algo3.modelo.equipamientos;
    exports edu.fiuba.algo3.modelo.gladiador.senority.states;
    exports edu.fiuba.algo3.modelo.celda;
    exports edu.fiuba.algo3.modelo.camino;
    exports edu.fiuba.algo3.data_acceso;
    exports edu.fiuba.algo3.data_acceso.repositories;
    exports edu.fiuba.algo3.data_acceso.DTOs;
    exports edu.fiuba.algo3.data_acceso.DAOs;
    exports edu.fiuba.algo3.data_acceso.data_mappers;
    exports edu.fiuba.algo3.modelo.constantes;
    exports edu.fiuba.algo3.modelo.gladiador.exepciones;
}