package com.example.modelmapperproj.service;


import com.example.modelmapperproj.dto.UnicornDTO;
import com.example.modelmapperproj.mapper.UnicornMapper;
import com.example.modelmapperproj.repository.UnicornRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnicornServiceImpl implements UnicornService {

    private final UnicornRepository repository;
    private final UnicornMapper mapper;

    @Autowired
    public UnicornServiceImpl(UnicornRepository repository, UnicornMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UnicornDTO save(UnicornDTO dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public UnicornDTO get(Long id) {
        return mapper.toDto(repository.getReferenceById(id));
    }
}
