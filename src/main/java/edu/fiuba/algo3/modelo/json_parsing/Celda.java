package edu.fiuba.algo3.modelo.json_parsing;

public class Celda {
    private int x;
    private int y;
    private String tipo;
    private String obstaculo;
    private String premio;

    public Celda() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObstaculo() {
        return obstaculo;
    }

    public void setObstaculo(String obstaculo) {
        this.obstaculo = obstaculo;
    }

    public String getPremio() {
        return premio;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }

    @Override
    public String toString() {
        return "Celda{" +
                "x=" + x +
                ", y=" + y +
                ", tipo='" + tipo + '\'' +
                ", obstaculo='" + obstaculo + '\'' +
                ", premio='" + premio + '\'' +
                '}';
    }
}
