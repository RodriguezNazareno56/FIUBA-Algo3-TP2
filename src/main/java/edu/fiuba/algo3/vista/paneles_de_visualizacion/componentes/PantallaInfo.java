package edu.fiuba.algo3.vista.paneles_de_visualizacion.componentes;

import edu.fiuba.algo3.modelo.consecuencias.IConsecuencia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import javafx.scene.layout.VBox;

public interface PantallaInfo {
    public VBox getPantallaConInfoDe(Gladiador gladiador, IConsecuencia consecuencia);
}
