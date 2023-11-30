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
import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.gladiador.exepciones.MovimientoPausadoExeption;
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
import org.slf4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso16Test {

    Path json = Paths.get("src/main/test/edu/fiuba/algo3/entrega_2/Json_test_resources/CasoDeUso16.json");
    private Gladiador gladiador;
    private MapaService mapaService;

    @BeforeEach
    public void setUp() throws Exception {
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        this.gladiador = new Gladiador(energia, equipamiento, senority, Mockito.mock(Logger.class));

        // Mock de dado para jugar bacanal, siempre retorna 1
        Dado dadoMockParaJugarBacanal = Mockito.mock(Dado.class);
        Mockito.when(dadoMockParaJugarBacanal.tirarDado()).thenReturn(1);

        // MapaService
        CaminoRepository caminoRepository = new CaminoRepositoryImpl(
                new CaminoDAOJsonImpl(json),
                new CaminoMapper(new CeldaMapper(dadoMockParaJugarBacanal)));
        MapaRepository mapaRepository = new MapaRepositoryImpl(
                new MapaDAOJsonImpl(json),
                new MapaMapper());
        this.mapaService = new MapaService(caminoRepository, mapaRepository);
    }

    @Test
    public void verificarLecturaYConversionUnidadesModeloDominioJsonMapa() throws Exception {
        // Misma estrategia que el casoDeUso15 pero ahora recorremos desde el mapa y no desde el camino. Comprobamos
        // tambien la correcta instanciacion de premios
        // TODO: supuesto: consideramos que este test busca probar la lectura y conversion de todas las unidades
        //  de modelo que finalmente constituyen un Mapa (camino, celdas, obstaculos y premios) y no tan solo
        //  "mapa": {
        //    "ancho": 10,
        //    "largo": 18
        //  },

        // Arrange
        // cargo un mapa de acuerdo al json y le seteo un gladiador
        Mapa mapa = mapaService.cargarMapa();
        mapa.setGladiador(gladiador);

        // Assert
        // avanzaremos al gladiador de a un posicion en el mapa y comprobaremos que las consecuencias experimentadas
        // por el gladiador se corresponda con el obstaculo/premio presente en la celda.

        // El json especifica, en la segunda celda un premio de equipamiento.
        // El gladiador ha sido inicializado con  puntos de energia y sin equipamiento se espera que reciba un casco.
        mapa.avanzarNPosicionesGladiador(gladiador,1);
        // El json especifica, en la tercer celda una Fiera.
        // Se espera que sea daniado por 15 puntos de energia ya que en la celda anterior recibio un casco.
        mapa.avanzarNPosicionesGladiador(gladiador,1);
        assertEquals(new Energia(5), gladiador.getEnergia());

        // El json especifica, en la cuarta celda un Lesion
        mapa.avanzarNPosicionesGladiador(gladiador,1);
        Assertions.assertThrows(MovimientoPausadoExeption.class, () -> {
            mapa.avanzarNPosicionesGladiador(gladiador,1);
        });
        ICelda mitadDeCamino = mapa.getPosicionDeGladiador(gladiador);

        // El json especifica, en la quinta celda un Premio de comida.
        // Se espera que el gladiador que poseia 5 puntos de energia incremente en 15 llegando asi a 20 puntos.
        mapa.avanzarNPosicionesGladiador(gladiador,1);
        assertEquals(new Energia(20), gladiador.getEnergia());

        // El json especifica, en la sexta celda un Bacanal. El dado con el que se juega el bacanal esta mockeado y
        // siempre retonar 1 por lo toma un solo trago y se pierde 4 puntos
        mapa.avanzarNPosicionesGladiador(gladiador,1);
        assertEquals(new Energia(16), gladiador.getEnergia());

        // Comprobada la conversion de todas las entidades del modelo (celdas, obstaculos, premios). Comprobaremos
        // que una celda especificada con un obstaculo y un premio al mismo tiempo es construida correctamente.
        // El json especifica, en la septima celda una Lesion y un premio de Comida.
        mapa.avanzarNPosicionesGladiador(gladiador,1);
        assertEquals(new Energia(16+15), gladiador.getEnergia());
        Assertions.assertThrows(MovimientoPausadoExeption.class, gladiador::avanzar);

        // El json especifica, en la octaba la celda final. Esperamos que se comporte como tal y siendo que el gladiador
        // no posee la llave, este sea retornado a mitad de casilleros.
        mapa.avanzarNPosicionesGladiador(gladiador,1);
        assertEquals(mitadDeCamino, mapa.getPosicionDeGladiador(gladiador));
    }
}
