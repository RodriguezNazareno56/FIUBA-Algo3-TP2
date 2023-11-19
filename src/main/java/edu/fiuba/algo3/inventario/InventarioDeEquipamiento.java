package edu.fiuba.algo3.inventario;

import edu.fiuba.algo3.Equipamientos.Equipamiento;

import java.util.ArrayList;;
import java.util.List;

public class InventarioDeEquipamiento implements Inventario<Equipamiento> {
    private List<Equipamiento> inventario;

    public InventarioDeEquipamiento(){
        this.inventario = new ArrayList<>();
    }

    @Override
    public void agregarSiNoExiste(Equipamiento equipamiento){
        var isEmpty = this.inventario.stream()
                .filter(inventario -> inventario.equals(equipamiento))
                .findAny()
                .isEmpty();
        if(isEmpty) this.inventario.add(equipamiento);

    }

    @Override
    public Equipamiento buscarPor(int indice){
        return this.inventario.get(indice);
    }

    @Override
    public Equipamiento buscarPor(Equipamiento equipamiento){
        return this.inventario
                .stream()
                .filter(equipamientoInventario -> equipamientoInventario.equals(equipamiento))
                .findFirst()
                .orElse(null);
    }
}
