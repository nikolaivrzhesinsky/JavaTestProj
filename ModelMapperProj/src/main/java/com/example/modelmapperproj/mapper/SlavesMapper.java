package com.example.modelmapperproj.mapper;

import com.example.modelmapperproj.dto.SlavesDTO;
import com.example.modelmapperproj.model.Slaves;
import com.example.modelmapperproj.repository.WizardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Objects;

public class SlavesMapper extends AbstractMapper<Slaves, SlavesDTO>{

    @Autowired
    private final ModelMapper mapper;
    private final WizardRepository wizardRepository;

    SlavesMapper(ModelMapper mapper, WizardRepository wizardRepository) {
        super(Slaves.class, SlavesDTO.class);
        this.mapper = mapper;
        this.wizardRepository = wizardRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Slaves.class, SlavesDTO.class)
                .addMappings(m -> m.skip(SlavesDTO::setWizardId)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(SlavesDTO.class, Slaves.class)
                .addMappings(m -> m.skip(Slaves::setWizard)).setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(Slaves source, SlavesDTO destination) {
        destination.setWizardId(getId(source));
    }

    private Long getId(Slaves source) {
        return Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getWizard().getId();
    }

    @Override
    void mapSpecificFields(SlavesDTO source, Slaves destination) {
        destination.setWizard(wizardRepository.findById(source.getWizardId()).orElse(null));
    }
}
