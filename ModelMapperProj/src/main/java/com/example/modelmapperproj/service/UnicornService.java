package com.example.modelmapperproj.service;

import com.example.modelmapperproj.dto.UnicornDTO;

public interface UnicornService {

    UnicornDTO save(UnicornDTO dto);

    UnicornDTO get(Long id);


}
