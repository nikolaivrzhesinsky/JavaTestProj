package com.example.modelmapperproj.mapper;

import com.example.modelmapperproj.dto.WizardDTO;
import com.example.modelmapperproj.model.Wizard;
import com.example.modelmapperproj.repository.UnicornRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class WizardMapper extends AbstractMapper<Wizard, WizardDTO> {

    @Autowired
    private final ModelMapper modelMapper;
    private final UnicornRepository unicornRepository;

    WizardMapper(Class<Wizard> entityClass, Class<WizardDTO> dtoClass, ModelMapper modelMapper, UnicornRepository unicornRepository) {
        super(entityClass, dtoClass);
        this.modelMapper = modelMapper;
        this.unicornRepository = unicornRepository;
    }

    @PostConstruct
    public void setupMapper(){
        modelMapper.createTypeMap(Wizard.class,WizardDTO.class)
                .addMappings(m->m.skip(WizardDTO::setUnicornId)).setConverter(toDtoConverter());
        modelMapper.createTypeMap(WizardDTO.class,Wizard.class)
                .addMappings(m->m.skip(Wizard::setUnicorn)).setPostConverter(toEntityConverter());
    }

    @Override
    public void mapSpecificFields(Wizard source, WizardDTO destination) {
        destination.setUnicornId(getId(source));
    }

    private Long getId(Wizard source) {
        return Objects.isNull(source) || Objects.isNull(source.getId()) ? null
                : source.getUnicorn().getId();
    }

    @Override
    void mapSpecificFields(WizardDTO source, Wizard destination) {
        destination.setUnicorn(unicornRepository.findById(source.getUnicornId()).orElse(null));
    }

}
