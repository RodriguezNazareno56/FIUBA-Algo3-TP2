package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.data_acceso.DAOs.CaminoDAOJsonImpl;
import edu.fiuba.algo3.data_acceso.data_mappers.CaminoMapper;
import edu.fiuba.algo3.data_acceso.data_mappers.CeldaMapper;
import edu.fiuba.algo3.data_acceso.repositories.CaminoRepository;
import edu.fiuba.algo3.data_acceso.repositories.CaminoRepositoryImpl;
import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.MovimientoPausadoExeption;
import edu.fiuba.algo3.modelo.camino.Camino;
import edu.fiuba.algo3.modelo.celda.ICelda;
import edu.fiuba.algo3.modelo.equipamientos.Casco;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso15Test {

    Path json = Paths.get("src/main/test/edu/fiuba/algo3/entrega_2/Json_test_resources/CasoDeUso15.json");
    private Gladiador gladiador;

    @BeforeEach
    public void setUp() {
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new Casco();
        Senority senority = new Senority();
        this.gladiador = new Gladiador(energia, equipamiento, senority, Mockito.mock(Logger.class));
    }

    @Test
    public void verificarLecturaYConversionUnidadesModeloDominioJsonEnemigos() throws Exception {
        // TODO: como supuesto consideramos Enemigos a los obstaculos. Comprobaremos que se hayan creado
        //  correctamente una Lesion, una FieraSalvaje y un Bacanal
        // Arrange
        Dado dadoMockParaJugarBacanal = Mockito.mock(Dado.class);
        Mockito.when(dadoMockParaJugarBacanal.tirarDado()).thenReturn(1);

        CaminoRepository caminoRepository = new CaminoRepositoryImpl(
                new CaminoDAOJsonImpl(json),
                new CaminoMapper(new CeldaMapper(dadoMockParaJugarBacanal)));

        // Act
        Camino camino = caminoRepository.obtener();

        // Assert
        // Voy a pedirle las celdas al camino y recorre una a una comprobando que posee el obstaculo indicado por el json
        List<ICelda> celdas = camino.getCeldas();

        // El json especifica, en la tercer celda un Lesion
        celdas.get(2).afectarGladiadorConConsecuencia(gladiador);
        Assertions.assertThrows(MovimientoPausadoExeption.class, gladiador::avanzar);

        // El json especifica, en la cuarta celda una Fiera. El gladiador ha sido inicializado con 20 puntos de energia
        // y con casco por lo que queda con 5 puntos de energia tras el ataque
        celdas.get(3).afectarGladiadorConConsecuencia(gladiador);
        assertEquals(new Energia(5), gladiador.getEnergia());

        // El json especifica, en la quinta celda un Bacanal. El dado con el que se juega el bacanal esta mockeado y
        // siempre retonar 1 por lo toma un solo trago y se pierde 4 puntos
        celdas.get(4).afectarGladiadorConConsecuencia(gladiador);
        assertEquals(new Energia(1), gladiador.getEnergia());
    }
}
