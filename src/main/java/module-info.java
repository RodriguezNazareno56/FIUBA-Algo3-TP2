module edu.fiuba.algo3 {
    requires javafx.controls;
    requires com.fasterxml.jackson.databind;
    requires org.json;
    requires org.slf4j;
    requires javafx.media;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.modelo;
    exports edu.fiuba.algo3.modelo.gladiador.senority;
    exports edu.fiuba.algo3.modelo.consecuencias;
    exports edu.fiuba.algo3.modelo.gladiador;
    exports edu.fiuba.algo3.modelo.algoRoma_estado;
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

    exports edu.fiuba.algo3.vista.equipamientos;
    exports edu.fiuba.algo3.vista;
    exports edu.fiuba.algo3.vista.dado;
    exports edu.fiuba.algo3.vista.gladiador;
    exports edu.fiuba.algo3.controladores.dado;
    exports edu.fiuba.algo3.controladores.observers;
    exports edu.fiuba.algo3.vista.gladiador.senority;
    exports edu.fiuba.algo3.modelo.dado;
    exports edu.fiuba.algo3.modelo.mapa;
    exports edu.fiuba.algo3.vista.mapa;
    exports edu.fiuba.algo3.vista.paneles_de_visualizacion;
    exports edu.fiuba.algo3.vista.components.animacion;
    exports edu.fiuba.algo3.modelo.excepciones;
}