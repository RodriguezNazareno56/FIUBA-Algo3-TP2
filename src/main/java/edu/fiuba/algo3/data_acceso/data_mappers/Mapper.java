package edu.fiuba.algo3.data_acceso.data_mappers;

public interface Mapper<T,Tdto> {
    T convertirDesdeDto(Tdto tdto) throws Exception;
}
