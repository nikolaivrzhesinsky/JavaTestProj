package com.example.modelmapperproj.mapper;

import com.example.modelmapperproj.dto.AbstractDTO;
import com.example.modelmapperproj.model.AbstractEntity;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;


public abstract class AbstractMapper<E extends AbstractEntity, D extends AbstractDTO> implements Mapper<E, D> {

    @Autowired
    ModelMapper mapper;

    private Class<E> entityClass;
    private Class<D> dtoClass;

    AbstractMapper(Class<E> entityClass, Class<D> dtoClass) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    @Override
    public E toEntity(D dto){
        return Objects.isNull(dto)
                ?null: mapper.map(dto,entityClass);
    }

    @Override
    public D toDto(E entity){
        return Objects.isNull(entity)
                ?null: mapper.map(entity,dtoClass);
    }

    Converter<D,E> toEntityConverter(){

        return mappingContext -> {
            D source= mappingContext.getSource();
            E destination= mappingContext.getDestination();
            mapSpecificFields(source, destination);
            return mappingContext.getDestination();
        };
    }

    Converter<E,D> toDtoConverter(){

        return mappingContext -> {
            E source= mappingContext.getSource();
            D destination= mappingContext.getDestination();
            mapSpecificFields(source,destination);
            return mappingContext.getDestination();
        };
    }

    void mapSpecificFields(E source, D destination) {
    }

    void mapSpecificFields(D source, E destination) {
    }



}
