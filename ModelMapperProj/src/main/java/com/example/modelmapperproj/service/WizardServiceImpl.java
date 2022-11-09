package com.example.modelmapperproj.service;

import com.example.modelmapperproj.dto.WizardDTO;
import com.example.modelmapperproj.mapper.WizardMapper;
import com.example.modelmapperproj.model.Unicorn;
import com.example.modelmapperproj.model.Wizard;
import com.example.modelmapperproj.repository.UnicornRepository;
import com.example.modelmapperproj.repository.WizardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WizardServiceImpl implements WizardService{

    private final WizardRepository wizardRepository;
    private final UnicornRepository unicornRepository;
    private final WizardMapper mapper;

    @Autowired
    public WizardServiceImpl(WizardRepository wizardRepository, UnicornRepository unicornRepository, WizardMapper mapper) {
        this.wizardRepository = wizardRepository;
        this.unicornRepository = unicornRepository;
        this.mapper = mapper;
    }

    @Override
    public WizardDTO save(WizardDTO dto) {

        return mapper.toDto(wizardRepository.save(mapper.toEntity(dto)));
    }

    @Override
    public WizardDTO get(Long id) {
        return mapper.toDto(wizardRepository.getReferenceById(id));
    }

    @Override
    public WizardDTO addUnicornToWizard(Long idUnicorn, Long idWizard) {

        Unicorn unicorn=unicornRepository.getReferenceById(idUnicorn);
        Wizard wizard=wizardRepository.getReferenceById(idWizard);

        wizard.setUnicorn(unicorn);
        wizardRepository.save(wizard);
        return mapper.toDto(wizard) ;
    }
}
