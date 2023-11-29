package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.data_acceso.DAOs.CaminoDAOJsonImpl;
import edu.fiuba.algo3.data_acceso.DAOs.MapaDAOJsonImpl;
import edu.fiuba.algo3.data_acceso.MapaService;
import edu.fiuba.algo3.data_acceso.data_mappers.CaminoMapper;
import edu.fiuba.algo3.data_acceso.data_mappers.CeldaMapper;
import edu.fiuba.algo3.data_acceso.data_mappers.MapaMapper;
import edu.fiuba.algo3.data_acceso.repositories.CaminoRepository;
import edu.fiuba.algo3.data_acceso.repositories.CaminoRepositoryImpl;
import edu.fiuba.algo3.data_acceso.repositories.MapaRepository;
import edu.fiuba.algo3.data_acceso.repositories.MapaRepositoryImpl;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.MovimientoPausadoExeption;
import edu.fiuba.algo3.modelo.celda.ICelda;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso17Test {

    Path json = Paths.get("src/main/test/edu/fiuba/algo3/entrega_2/Json_test_resources/CasoDeUso16.json");

    @Test
    public void verificarCreacionJuegoAcordeJson() throws Exception {
        // TODO: Basicamente se puede hacer lo mismo que en el casoDeUso18 pero desde AlgoRoma, osea iniciando el juego.
        // Arrange
        CaminoRepository caminoRepository = new CaminoRepositoryImpl(
                new CaminoDAOJsonImpl(json),
                new CaminoMapper(new CeldaMapper()));
        MapaRepository mapaRepository = new MapaRepositoryImpl(
                new MapaDAOJsonImpl(json),
                new MapaMapper());
        MapaService mapaService = new MapaService(caminoRepository, mapaRepository);

        // Mockeo el dado para que siempre se avance de a una posicion
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.tirarDado()).thenReturn(1);

        // Creo un algo roma y le agrego un gladiador
        AlgoRoma algoRoma = new AlgoRoma(mapaService, dado);
        algoRoma.agregarGladiador("Mike Tyson");

        algoRoma.inicializarJuego();

        // TODO: Como observo a mike tyson ahhhhhhhh (re trucho este get)
        Gladiador gladiador = null;
        for (Gladiador gladiadorActual : algoRoma.getGladiadores()) {
            if (gladiadorActual.getNombre().equals("Mike Tyson")) {
                gladiador = gladiadorActual;
            }
        }

        // Assert

        // El json especifica, en la segunda celda un premio de equipamiento.
        // El gladiador ha sido inicializado con  puntos de energia y sin equipamiento se espera que reciba un casco.
        algoRoma.jugarTurno();
        // El json especifica, en la tercer celda una Fiera.
        // Se espera que sea daniado por 15 puntos de energia ya que en la celda anterior recibio un casco.
        algoRoma.jugarTurno();
        assertEquals(new Energia(5), gladiador.getEnergia());

        // El json especifica, en la cuarta celda un Lesion
        algoRoma.jugarTurno();
        Assertions.assertThrows(Exception.class, algoRoma::jugarTurno);
//        ICelda mitadDeCamino = mapa.getPosicionDeGladiador(gladiador);

        // El json especifica, en la quinta celda un Premio de comida.
        // Se espera que el gladiador que poseia 5 puntos de energia incremente en 15 llegando asi a 20 puntos.
        algoRoma.jugarTurno();
        assertEquals(new Energia(20), gladiador.getEnergia());

        // El json especifica, en la sexta celda un Bacanal
        // TODO: por el momento el bacanal es inicializado con 1 trago por lo que pierde 4 puntos de energia
        algoRoma.jugarTurno();
        assertEquals(new Energia(16), gladiador.getEnergia());

        // Comprobada la conversion de todas las entidades del modelo (celdas, obstaculos, premios). Comprobaremos
        // que una celda especificada con un obstaculo y un premio al mismo tiempo es construida correctamente.
        // El json especifica, en la septima celda una Lesion y un premio de Comida.
        algoRoma.jugarTurno();
        assertEquals(new Energia(16+15), gladiador.getEnergia());
        Assertions.assertThrows(Exception.class, gladiador::avanzar);

        // El json especifica, en la octaba la celda final. Esperamos que se comporte como tal y siendo que el gladiador
        // no posee la llave, este sea retornado a mitad de casilleros.
        // TODO: verificar que esta casilla es la final
//        algoRoma.jugarTurno();
//        assertEquals(mitadDeCamino, mapa.getPosicionDeGladiador(gladiador));
    }
}
