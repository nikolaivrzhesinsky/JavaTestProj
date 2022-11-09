package com.example.modelmapperproj.service;

import com.example.modelmapperproj.dto.WizardDTO;

public interface WizardService {

    WizardDTO save(WizardDTO dto);

    WizardDTO get(Long id);

    WizardDTO addUnicornToWizard(Long idUnicorn, Long idWizard);
}
