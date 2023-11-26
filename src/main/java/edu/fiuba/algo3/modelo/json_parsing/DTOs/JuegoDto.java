package edu.fiuba.algo3.modelo.json_parsing.DTOs;

public class JuegoDto {
    private MapaDto mapa;
    private CaminoDto camino;

    public JuegoDto() {
    }

    public MapaDto getMapa() {
        return mapa;
    }

    public void setMapa(MapaDto mapaDto) {
        this.mapa = mapaDto;
    }

    public CaminoDto getCamino() {
        return camino;
    }

    public void setCamino(CaminoDto caminoDto) {
        this.camino = caminoDto;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "mapa=" + mapa +
                ", camino=" + camino +
                '}';
    }
}
