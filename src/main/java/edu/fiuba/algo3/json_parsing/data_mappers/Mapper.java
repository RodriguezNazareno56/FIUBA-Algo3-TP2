package edu.fiuba.algo3.json_parsing.data_mappers;

public interface Mapper<T,Tdto> {
    T convertirDesdeDto(Tdto tdto) throws Exception;
}
