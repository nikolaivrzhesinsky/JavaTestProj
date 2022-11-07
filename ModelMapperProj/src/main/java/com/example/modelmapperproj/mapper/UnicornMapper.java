package com.example.modelmapperproj.mapper;

import com.example.modelmapperproj.dto.UnicornDTO;
import com.example.modelmapperproj.model.Unicorn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UnicornMapper extends AbstractMapper<Unicorn, UnicornDTO> {

    @Autowired
    public UnicornMapper() {
        super(Unicorn.class, UnicornDTO.class);
    }
}
