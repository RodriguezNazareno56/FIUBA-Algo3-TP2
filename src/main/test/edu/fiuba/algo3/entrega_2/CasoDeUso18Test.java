package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.data_acceso.MapaService;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;
import org.slf4j.Logger;



public class CasoDeUso18Test {

    Logger loggerMock;
    AlgoRoma algoRoma;

    @BeforeEach
    public void setUp() throws Exception {
        // Mockeo el logger
        this.loggerMock = Mockito.mock(Logger.class);

        // Mockeo el mapaService
        MapaService mapaServiceMock = Mockito.mock(MapaService.class);
        Mockito.when(mapaServiceMock.cargarMapa()).thenReturn(Mockito.mock(Mapa.class));

        // Instancio AlgoRoma
        this.algoRoma = new AlgoRoma(mapaServiceMock, Mockito.mock(Dado.class), loggerMock);

        //iniciado algoRoma
        this.algoRoma.agregarGladiador("Espartaco");
        this.algoRoma.agregarGladiador("Augusto");
        this.algoRoma.jugarTurno();
    }

    @Test
    public void verificarSistemaLogNecesarioEntrega3() {
        // Act

        // Verify
        // this.logger.info("Juego inicilizado") al inicializar juego
        VerificationMode callJustOnce = Mockito.times(1);
        Mockito.verify(loggerMock, callJustOnce).info("Juego inicilizado");
    }
}
