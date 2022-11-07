package com.example.modelmapperproj.mapper;

import com.example.modelmapperproj.dto.AbstractDTO;
import com.example.modelmapperproj.model.AbstractEntity;

public interface Mapper<E extends AbstractEntity,D extends AbstractDTO> {

    E toEntity(D dto);

    D toDto(E entity);
}
