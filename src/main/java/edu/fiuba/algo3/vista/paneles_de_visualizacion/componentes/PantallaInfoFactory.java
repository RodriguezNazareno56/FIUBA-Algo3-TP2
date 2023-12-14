package edu.fiuba.algo3.vista.paneles_de_visualizacion.componentes;

import edu.fiuba.algo3.modelo.consecuencias.*;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

import java.util.HashMap;

public class PantallaInfoFactory {
    HashMap<String, PantallaInfo> pantallasInfo;
    public PantallaInfoFactory() {
       this.pantallasInfo = new HashMap<>();
       pantallasInfo.put("Comida", new ComidaInfo());
       pantallasInfo.put("Equipamiento Incrementado", new EquipamientoIncrementadoInfo());
       pantallasInfo.put("Ataque de fiera salvaje", new FieraSalvajeInfo());
       pantallasInfo.put("Asiste a un Bacanal", new BacanalInfo());
       pantallasInfo.put("Sufre una Lesion", new LesionInfo());
    }

    public PantallaInfo getPantallaInfo(IConsecuencia consecuencia, Gladiador gladiador) {
        PantallaInfo pantallaInfo;
        try {
            pantallaInfo = pantallasInfo.get(consecuencia.toString());
            return (PantallaInfo) pantallaInfo.getPantallaConInfoDe(gladiador, consecuencia);
        }
        // si no hay pantalla para la consecuencia, se ignora
        catch(Exception ignore) {
        }
        return null;
    }
}
